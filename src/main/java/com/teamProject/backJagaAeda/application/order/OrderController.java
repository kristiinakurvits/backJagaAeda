package com.teamProject.backJagaAeda.application.order;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/check")
    @Operation(summary = "Kontrolli, kas order on  loodud")
    public CartInfo checkIfOrderHasStarted(Integer buyerUserId) {
        return orderService.checkIfOrderHasStarted(buyerUserId);
    }

    @PostMapping ("/add")
    @Operation(summary = "Lisan toote ostukorvi")
    public void addProductToCart(@RequestBody CartInfo cartInfo) {
        orderService.addProductToCart(cartInfo);

    }

}
