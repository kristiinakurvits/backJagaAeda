package com.teamProject.backJagaAeda.application.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LogInController {

    @Resource
    private LogInService loginService;


    @PostMapping("/sisene")
    @Operation(summary = "Sisse logimine")
    public LogInResponse logIn(@RequestBody LogInRequest request) {
        return loginService.logIn(request);
    }

    @PostMapping("/registreeru")
    @Operation(summary = "Uue kasutaja loomine")
    public LogInResponse register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
    }
}
