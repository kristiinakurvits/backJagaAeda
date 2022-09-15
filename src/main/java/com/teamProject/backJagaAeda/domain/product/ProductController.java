package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.application.product.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private BusinessService businessService;

    @Resource
    private ProductService productService;

    @PostMapping("/new")
    @Operation(summary = "Uue kuulutuse lisamine")
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Leiab kõik tooted")
    public List<ProductInfo> findAllProducts() {
        return businessService.findAllProducts();
    }

    @GetMapping("/recent")
    @Operation(summary = "Leiab 5 viimati lisatud toodet")
    public List<ProductInfo> findRecentProducts() {
        return businessService.findRecentProducts();
    }

    @GetMapping("/category")
    @Operation(summary = "Leiab tooted kategooria järgi")
    public List<ProductInfo> findProductsByCategory(Integer categoryId) {
        return businessService.findProductsByCategory(categoryId);
    }

    @GetMapping("/region")
    @Operation(summary = "Leiab tooted regiooni järgi")
    public List<ProductInfo> findProductsByRegionId(Integer regionId) {
        return businessService.findProductsByRegionId(regionId);
    }

    @GetMapping("/user")
    @Operation(summary = "Leiab tooted kasutaja järgi")
    public List<ProductInfo> findProductsByUserId(Integer userId) {
        return businessService.findProductsByUserId(userId);
    }

    @GetMapping("/buyer")
    @Operation(summary = "Leiab tooted ostja järgi")
    public List<ProductInfo> findProductsByBuyerId(Integer buyerId) {
        return businessService.findProductsByBuyerId(buyerId);
    }
}


