package com.teamProject.backJagaAeda.domain.product;

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

    @GetMapping("/category")
    @Operation(summary = "Leiab tooted kategooria järgi")
    public List<ProductInfo> findProducts(Integer categoryId) {

        return businessService.findProducts(categoryId);
    }

    @PostMapping("/new")
    @Operation(summary = "Uue kuulutuse lisamine")
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Leiab kõik tooted")
    public List<ProductInfo> getAllProducts() {
        return businessService.getAllProducts();
    }

//    @GetMapping("/recent")
//    @Operation(summary = "Leiab viimati lisatud tooted")
//    public List<ProductInfo> findRecentProducts(LocalDate dateAdded) {
//        return businessService.findRecentProducts(dateAdded);
//    }


}


