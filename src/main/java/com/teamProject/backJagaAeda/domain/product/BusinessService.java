package com.teamProject.backJagaAeda.domain.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    public List<ProductInfo> findProducts(Integer categoryId) {
        return productService.findProducts(categoryId);
    }

    public List<ProductInfo> findAllProducts() {
        return productService.findAllProducts();

    }

    public List<ProductInfo> findRecentProducts() {
        return productService.findRecentProducts();
    }
}
