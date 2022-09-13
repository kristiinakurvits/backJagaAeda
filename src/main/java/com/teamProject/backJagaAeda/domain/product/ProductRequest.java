package com.teamProject.backJagaAeda.domain.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {
    private Integer userId;
    private Integer categoryId;
    private String name;
    private String description;
    private Integer quantity;
    private Integer measureUnitId;
    private byte[] imageBase64;
}
