package com.teamProject.backJagaAeda.domain.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductMapper productMapper;


    public List<ProductInfo> findProducts(Integer categoryId) {
        List<Product> products = productRepository.findProductsBy(categoryId);
         return productMapper.productsToProductInfos(products);
    }
}
//    public List<ProductInfo> findProducts(Integer categoryId) {
//        List<Product> products = productRepository.findProductsBy(categoryId);
//        List<ProductInfo> category = productMapper.productsToProductInfos(products);
//        return ;
