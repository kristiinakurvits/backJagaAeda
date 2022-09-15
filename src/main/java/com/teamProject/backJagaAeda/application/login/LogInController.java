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
    public LogInResponse register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
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
// TODO: 14.09.2022 Display profile information by user_ID (profileView)
// TODO: 14.09.2022 Save contact/address (save address/addresses in profileView
//add location information to contact Id
// TODO: 14.09.2022 Update contact/address (update address/addresses in profileWiev
