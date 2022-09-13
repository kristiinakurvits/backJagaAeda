package com.teamProject.backJagaAeda.domain.product;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}



}
