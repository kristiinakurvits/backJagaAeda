package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public RegisterResponse registerNewUser(@RequestBody RegisterRequest request) {
        return loginService.registerNewUser(request);
    }

    // TODO: 15.09.2022 service lõpetada (mäpper)
    @GetMapping("/contact")
    public ContactInfo findContactDetail(Integer contactId) {
        return userService.findContactDetail(contactId);
    }

    @PatchMapping("/contact")
    @Operation(summary = "Lisa kliendi profiilile puuduolev nimi, perekonnanimi, mobiili number")
    public void updateContactDetail(@RequestBody ContactInfo request) {
        userService.updateContactDetail(request);
    }

    // TODO: 15.09.2022 service lõpetada (mäpper)
    @GetMapping("/location")
    public List<LocationRequest> findContactLocationsByContactId(Integer contactId) {
        return userService.findContactLocationsByContactId(contactId);
    }

    // TODO: 15.09.2022 service lõpetada (mäpper)
    @PostMapping("/address")
    @Operation(summary = "Lisa kliendi profiilile aadressi informatsioon userId järgi")
    public void addAddress(@RequestBody LocationRequest request) {
        userService.addAddress(request);
    }

}