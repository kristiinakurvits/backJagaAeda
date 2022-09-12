package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Service
    private ProductMapper productMapper;

    @Service
    private UserService userService;

    public void addProduct(ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);
        User user = userService.getValidUser(request.getUserId());
        product.setUser(user);
        productRepository.save(product);

    }

    //TODO: lisa siia juurde productrepository ja kuidas saada seda kätte productservicest, arvestades, et meil on seda erinevates kohtades
}
