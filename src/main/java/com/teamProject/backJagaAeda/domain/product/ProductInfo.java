package com.teamProject.backJagaAeda.domain.product;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductInfo implements Serializable {
    private Integer productId;
    private String name;
    private String description;
    private Integer quantity;
    private Integer measureUnitId;
    private String measureUnitUnit;
    private Boolean isActive;
    private LocalDate dateAdded;
    private String status;
    private Integer sellerUserId;
    private Integer sellerUserRoleId;
    private String sellerUserRoleName;
    private String sellerUserUserName;
    private String sellerUserPassword;
    private Integer categoryId;
    private String categoryName;
}