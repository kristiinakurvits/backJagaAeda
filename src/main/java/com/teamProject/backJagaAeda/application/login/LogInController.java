package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.application.user.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LogInController {

    @Resource
    private LoginService loginService;

    @PostMapping("/sisene")
    @Operation(summary = "Sisse logimine")
    public UserInfo logIn(@RequestBody LogInRequest request) {
        return loginService.logIn(request);
    }
}
