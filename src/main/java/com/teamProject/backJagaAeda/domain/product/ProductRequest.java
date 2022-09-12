package com.teamProject.backJagaAeda.domain.product;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProductRequest implements Serializable {
    private String categoryName;
    private String name;
    private String description;
    private Integer quantity;
    private String measureUnitUnit;
    private byte[] imageBase64;
}
