package com.teamProject.backJagaAeda.domain.product;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource
    private BusinessService businessService;

    @GetMapping("/product/category")
    @Operation(summary = "Leiab tooted kategooria järgi")
    public List<ProductInfo> findProducts(Integer categoryId) {
         return businessService.findProducts(categoryId);
    }

}

//    public List<ProductInfo> findProducts(Integer categoryId) {
//        List<ProductInfo> productInfos = businessService.findProducts(categoryId);
//        return null;