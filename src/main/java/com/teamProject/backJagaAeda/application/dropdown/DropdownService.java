package com.teamProject.backJagaAeda.application.dropdown;

import com.teamProject.backJagaAeda.domain.product.category.Category;
import com.teamProject.backJagaAeda.domain.product.category.CategoryMapper;
import com.teamProject.backJagaAeda.domain.product.category.CategoryService;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnit;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnitDto;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnitMapper;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnitService;
import com.teamProject.backJagaAeda.domain.user.region.Region;
import com.teamProject.backJagaAeda.domain.user.region.RegionMapper;
import com.teamProject.backJagaAeda.domain.user.region.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DropdownService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private RegionService regionService;
    @Resource
    private RegionMapper regionMapper;

    @Resource
    private MeasureUnitService measureUnitService;

    @Resource
    private MeasureUnitMapper measureUnitMapper;


    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categoryMapper.categoriesToCategoryDtos(categories);
    }

    public List<RegionDto> getAllRegions() {
        List<Region> regions = regionService.getAllRegions();
        return regionMapper.categoriesToCategoryDtos(regions);
    }

    public List<MeasureUnitDto> getAllMeasureUnits() {
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        return measureUnitMapper.measureUnitToMeasureUnitDtos(measureUnits);
    }
}
