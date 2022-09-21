package com.teamProject.backJagaAeda.application.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {
    private Integer userId;
    private String userName;
    private Integer categoryId;
    private String categoryName;
    private String name;
    private String description;
    private Integer quantity;
    private Integer measureUnitId;
    private Integer locationId;
    private String regionName;
    private byte[] imageBase64;
}
