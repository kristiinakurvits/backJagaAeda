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

    @PatchMapping("/contact")
    @Operation(summary = "Lisa kliendi profiilile puuduolev nimi, perekonnanimi, mobiili number")
    public void updateContactDetail(@RequestBody ContactInfo request) {
        userService.updateContactDetail(request);
    }

    @PostMapping("/address")
    @Operation(summary = "Lisa kliendi profiilile aadressi informatsioon userId järgi")
    public void addAddress(@RequestBody ContactInfo request) {
        userService.addAddress(request);
    }
//        public void addAddress(@RequestBody LocationInfo request) {
//            userService.addAddress(request)
    }

    // TODO: 14.09.2022 Display profile information by user_ID (profileView)
    // TODO: 14.09.2022 Save contact/address (save address/addresses in profileView
    //add location information to contact Id
    // TODO: 14.09.2022 Update contact/address (update address/addresses in profileWiev
