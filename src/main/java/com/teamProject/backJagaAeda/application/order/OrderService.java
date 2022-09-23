package com.teamProject.backJagaAeda.application.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import com.teamProject.backJagaAeda.domain.order.*;
import com.teamProject.backJagaAeda.domain.product.Product;
import com.teamProject.backJagaAeda.domain.product.ProductRepository;
import com.teamProject.backJagaAeda.domain.product.ProductService;
import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserRepository;
import com.teamProject.backJagaAeda.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.teamProject.backJagaAeda.application.OrderStatus.CONFIRMED;
import static com.teamProject.backJagaAeda.application.OrderStatus.PENDING;
import static com.teamProject.backJagaAeda.application.Status.*;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ProductOrderMapper productOrderMapper;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductOrderRepository productOrderRepository;

    @Resource
    private ProductService productService;

    @Resource
    private UserRepository userRepository;

    public CartInfo checkIfOrderHasStarted(Integer buyerUserId) {
        Optional<Order> optionalOrder = orderRepository.findOrderByBuyerUserIdAndStatus(buyerUserId, PENDING);
        CartInfo cartInfo = new CartInfo();
        if (optionalOrder.isPresent()) {
            cartInfo.setOrderId(optionalOrder.get().getId());
            cartInfo.setOrderHasStarted(true);
        } else {
            cartInfo.setOrderHasStarted(false);
        }
        return cartInfo;
    }

    public void addProductToCart(CartInfo cartInfo) {

        if (cartInfo.getOrderHasStarted()) {
            Order order = orderRepository.findById(cartInfo.getOrderId()).get();
            findAndSaveProductOrder(cartInfo.getProductId(), order);

        } else {
            User user = userRepository.findById(cartInfo.getBuyerUserId()).get();
            Order order = createAndSavePendingOrder(user);
            findAndSaveProductOrder(cartInfo.getProductId(), order);
        }
    }

    private Order createAndSavePendingOrder(User user) {
        Order order = new Order();
        order.setBuyerUser(user);
        order.setStatus(PENDING);
        order.setDateTime(Instant.now());
        orderRepository.save(order);
        return order;
    }

    private void findAndSaveProductOrder(Integer productId, Order order) {
        Product product = productRepository.findById(productId).get();
        product.setStatus(BOOKED);
        productRepository.save(product);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(product);
        productOrder.setOrder(order);
        productOrderRepository.save(productOrder);
    }

    public List<ProductInfo> findPendingProductsByBuyerUserId(Integer buyerUserId) {
        List<ProductOrder> productOrders = productOrderRepository.findProductsByStatusAndBuyerId(PENDING, buyerUserId);
        return productOrderMapper.productOrdersToProductInfos(productOrders);
    }

    public void confirmOrderAndChangeStatuses(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        ValidationService.validateOrderExists(optionalOrder);
        Order order = optionalOrder.get();
        ValidationService.validateOrderStatusPending(order);
        order.setStatus(CONFIRMED);
        orderRepository.save(order);
        for (ProductOrder productOrder : productOrderRepository.findProductsByOrderId(orderId)) {
            Product product = productOrder.getProduct();
            product.setStatus(COMPLETED);
            product.setIsActive(false);
            productRepository.save(product);
        }
    }

    public void deletePendingProductByProductOrderId(Integer productOrderId) {
        ProductOrder productOrder = productOrderRepository.findById(productOrderId).get();
        Product product = productOrder.getProduct();
        product.setStatus(AVAILABLE);
        productRepository.save(product);
        productOrderRepository.delete(productOrder);
    }
}