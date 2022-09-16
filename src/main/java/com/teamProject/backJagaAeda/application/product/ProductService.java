package com.teamProject.backJagaAeda.application.product;

import com.teamProject.backJagaAeda.domain.order.ProductOrderMapper;
import com.teamProject.backJagaAeda.domain.order.ProductOrder;
import com.teamProject.backJagaAeda.domain.order.ProductOrderRepository;
import com.teamProject.backJagaAeda.domain.product.Product;
import com.teamProject.backJagaAeda.domain.product.ProductMapper;
import com.teamProject.backJagaAeda.domain.product.ProductRepository;
import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.teamProject.backJagaAeda.application.Status.AVAILABLE;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserService userService;

    @Resource
    private ProductOrderRepository productOrderRepository;

    @Resource
    private ProductOrderMapper productOrderMapper;

    public List<ProductInfo> findProducts(Integer categoryId) {
        List<Product> products = productRepository.findProductsByCategory(categoryId, AVAILABLE);
        return productMapper.productsToProductInfos(products);
    }

    public ProductResponse addProduct(ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);
        User user = userService.getValidUser(request.getUserId());
        product.setSellerUser(user);
        product.setDateAdded(LocalDate.now());
        product.setIsActive(true);
        product.setStatus(AVAILABLE);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductResponse(savedProduct);
    }

    public List<ProductInfo> findProductsByRegionId(Integer regionId) {
        List<Product> products = productRepository.findProductsByRegionId(regionId, AVAILABLE);
        return productMapper.productsToProductInfos(products);
    }

    public List<ProductInfo> findProductsByUserId(Integer userId) {
        List<Product> products = productRepository.findProductsByUserId(userId);
        return productMapper.productsToProductInfos(products);
    }

    public List<ProductInfo> findAllProducts() {
        List<Product> products = productRepository.findAllProductsByStatus(AVAILABLE);
        return productMapper.productsToProductInfos(products);
    }

    public List<ProductInfo> findRecentProducts() {
        List<Product> products = productRepository.findAllProductsByStatus(AVAILABLE);
        List<ProductInfo> productInfos = productMapper.productsToProductInfos(products);
        return productInfos.stream().limit(5).collect(Collectors.toList());
    }

    public List<ProductInfo> findProductsByBuyerId(Integer buyerId) {
        List<ProductOrder> products = productOrderRepository.findProductsByBuyerId(buyerId);
        return productOrderMapper.productsToProductInfos(products);
    }

    public ProductRequest findProductDetails(Integer productId) {
        Product product = productRepository.findById(productId).get();
        return productMapper.productToProductRequest(product);

    }

}


