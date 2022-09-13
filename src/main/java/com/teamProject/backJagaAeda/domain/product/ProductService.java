package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {


    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserService userService;

    @Resource
    private ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);
        User user = userService.getValidUser(request.getUserId());
        product.setSellerUser(user);
        product.setDateAdded(LocalDate.now());
        product.setIsActive(true);
        product.setStatus("A");
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductResponse(savedProduct);

    }

//    public List<ProductInfo> getAllProducts() {
//        List<Product> products =
////        return productRepository.findAll();
//    }
}
