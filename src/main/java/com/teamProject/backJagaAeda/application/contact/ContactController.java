package com.teamProject.backJagaAeda.application.contact;

import com.teamProject.backJagaAeda.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Resource
    private UserService userService;


    @GetMapping("/contact/{userId}")
    @Operation(summary = "Kuva kasutaja profiilile isiku andmed userId järgi")
    public ContactInfo findContactDetail(@PathVariable Integer userId) {
        return userService.findContactDetail(userId);
    }

    @GetMapping("/location/{contactId}")
    @Operation(summary = "Kuva kasutaja profiilile isiku aadressi andmed contactId järgi")
    public List<LocationRequest> findContactLocationsByContactId(@PathVariable Integer contactId) {
        return userService.findContactLocationsByContactId(contactId);
    }

    @PatchMapping("/contact")
    @Operation(summary = "Lisa kliendi profiilile puuduolev nimi, perekonnanimi, mobiili number")
    public void updateContactDetail(@RequestBody ContactInfo request) {
        userService.updateContactDetail(request);
    }

    @PatchMapping("/address")
    @Operation(summary = "Muuda kliendi aadress ja 'regionId' 'locationId' järgi.")
    public void updateAddressDetail(@RequestBody LocationInfo request) {
        userService.updateAddressDetail(request);
    }


    @PostMapping("/address")
    @Operation(summary = "Lisa 'contactId'-le ja 'regionId'-e aadressi informatsioon")
    public void addAddress(@RequestBody LocationRequest request) {
        userService.addAddress(request);
    }
}
