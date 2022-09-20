package com.teamProject.backJagaAeda.application.dropdown;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dropdown")
public class DropdownController {
    @Resource
    private DropdownService dropdownService;

    @GetMapping("/category")
    @Operation(summary = "Kuva kategooriate nimed ja Id-d")
    public List<CategoryDto> getAllCategories() {
        return dropdownService.getAllCategories();
    }

    @GetMapping("/region")
    @Operation(summary = "Kuva maakondade nimed ja Id-d")
    public List<RegionDto> getAllRegions() {
        return dropdownService.getAllRegions();
    }
}
