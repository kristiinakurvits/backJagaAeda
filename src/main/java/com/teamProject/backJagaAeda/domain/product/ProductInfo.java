package com.teamProject.backJagaAeda.domain.product;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProductInfo implements Serializable {
    private final Integer id;
    private final Integer sellerUserId;
    private final Integer sellerUserRoleId;
    private final String sellerUserRoleName;
    private final String sellerUserUserName;
    private final String sellerUserPassword;
    private final Integer categoryId;
    private final String categoryName;
    private final String name;
    private final String description;
    private final Integer quantity;
    private final Integer measureUnitId;
    private final String measureUnitUnit;
    private final Boolean isActive;
    private final byte[] imageBase64;
    private final LocalDate dateAdded;
    private final String status;
}
