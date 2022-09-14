package com.teamProject.backJagaAeda.domain.product;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductInfo implements Serializable {
    private Integer productId;
    private Integer sellerUserId;
    private String productName;
    private Integer quantity;
    private String measureUnit;
    private String imageBase64;
    private String regionName;
    private Integer categoryId;
}