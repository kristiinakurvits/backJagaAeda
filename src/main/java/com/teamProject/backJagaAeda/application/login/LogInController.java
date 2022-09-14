package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class LogInController {

    @Resource
    private LogInService loginService;

    @Resource
    private UserService userService;


    @PostMapping("/login")
    @Operation(summary = "Sisse logimine")
    public LogInResponse logIn(@RequestBody LogInRequest request) {
        return loginService.logIn(request);
    }

    @PostMapping("/register")
    @Operation(summary = "Uue kasutaja loomine")
    public LogInResponse register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
    }


    // TODO: 13.09.2022 Lisa userile puuduolevad väljad
    // TODO: 13.09.2022
    @PatchMapping("/contact")
    @Operation(summary = "Lisa kliendi profiilile puuduolevad kontaktandmed")
    public void updateContactDetail(@RequestBody ContactInfo request) {
        userService.updateContactDetail(request);
    }

//    public ProductResponse addProduct(@RequestBody ProductRequest request) {
//        return productService.addProduct(request);

}
