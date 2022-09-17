package com.teamProject.backJagaAeda.application.order;

import com.teamProject.backJagaAeda.domain.order.*;
import com.teamProject.backJagaAeda.domain.product.Product;
import com.teamProject.backJagaAeda.domain.product.ProductRepository;
import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Optional;

import static com.teamProject.backJagaAeda.application.OrderStatus.PENDING;
import static com.teamProject.backJagaAeda.application.Status.BOOKED;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductOrderRepository productOrderRepository;

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
}
