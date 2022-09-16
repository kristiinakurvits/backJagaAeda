package com.teamProject.backJagaAeda.application.product;

import com.teamProject.backJagaAeda.domain.product.ProductMapper;
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

    public List<ProductInfo> findProductsByRegionId(Integer regionId) {
        return productService.findProductsByRegionId(regionId);
    }

    public List<ProductInfo> findProductsByUserId(Integer userId) {
        return productService.findProductsByUserId(userId);
    }

    public List<ProductInfo> findProductsByBuyerId(Integer buyerId) {
        return productService.findProductsByBuyerId(buyerId);
    }

    public List<ProductInfo> findAllProducts() {
        return productService.findAllProducts();
    }

    public List<ProductInfo> findRecentProducts() {
        return productService.findRecentProducts();
    }


}
