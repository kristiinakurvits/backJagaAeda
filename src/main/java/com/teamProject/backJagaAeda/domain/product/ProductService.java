package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.domain.user.Region;
import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserService userService;


    public List<ProductInfo> findProducts(Integer categoryId) {
        List<Product> products = productRepository.findProductsBy(categoryId);
        return productMapper.productsToProductInfos(products);

//        List<ProductInfo> productInfos = productMapper.productsToProductInfos(products);
//        for (ProductInfo productInfo : productInfos) {
//            Region region = productService.findRegionByUserId(productInfo.getSellerUserId());
//            productInfo.setRegionName(region.getCounty());
//        }
//        return productInfos;
    }

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

    public List<ProductInfo> findProductsByRegionId(Integer regionId) {
        List<Product> products = productRepository.findProductsByRegionId(regionId);
        return productMapper.productsToProductInfos(products);
    }

}


