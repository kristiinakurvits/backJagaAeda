package com.teamProject.backJagaAeda.domain.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
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

    public List<ProductInfo> findAllProducts(Integer productId) {
        return productService.findAllProducts(productId);
    }

    public List<ProductInfo> findRecentProducts(LocalDate dateAdded) {
        return productService.findRecentProducts(dateAdded);
    }
}
