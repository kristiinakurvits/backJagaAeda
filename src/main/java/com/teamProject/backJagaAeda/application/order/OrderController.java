package com.teamProject.backJagaAeda.application.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/add")
    @Operation(summary = "Lisa toode ostukorvi")
    public void addProductToCart(@RequestBody CartInfo cartInfo) {
        orderService.addProductToCart(cartInfo);
    }

    @GetMapping("/list")
    @Operation(summary = "Leiab kõik ostukorvis olevad tooted orderId abil")
    public List<ProductInfo> findProductsByOrderId(Integer orderId) {
        return orderService.findProductsByOrderId(orderId);
    }

//    @PatchMapping("/confirm/{orderId}")
//    @Operation(summary = "Kinnitab tellimuse ja muudab orderStatust ja productStatust")
//    public void confirmOrderAndChangeStatuses(@PathVariable Integer orderId) {
//        orderService.confirmOrderAndChangeStatuses(orderId);
//    }
}
