package com.teamProject.backJagaAeda.domain.product.category;

import com.teamProject.backJagaAeda.application.dropdown.CategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    CategoryDto categoryToCategoryDto(Category category);

    List<CategoryDto> categoriesToCategoryDtos(List<Category> categories);
}
