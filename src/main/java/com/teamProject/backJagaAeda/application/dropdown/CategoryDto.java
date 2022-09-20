package com.teamProject.backJagaAeda.application.dropdown;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.teamProject.backJagaAeda.domain.product.category.Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Integer categoryId;
    private final String name;
}