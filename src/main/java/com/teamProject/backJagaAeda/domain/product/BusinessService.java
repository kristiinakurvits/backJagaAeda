package com.teamProject.backJagaAeda.domain.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BusinessService {

    @Resource
    private ProductService productService;

    public List<ProductInfo> findProducts(Integer categoryId) {
        return productService.findProducts(categoryId);
    }
}

//    public List<ProductInfo> findProducts(Integer categoryId) {
//        List<ProductInfo> productInfos = productService.findProducts(categoryId);
//        return productInfos ;