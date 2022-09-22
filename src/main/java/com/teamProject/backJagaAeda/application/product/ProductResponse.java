package com.teamProject.backJagaAeda.application.product;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProductResponse implements Serializable {
    private final Integer id;
    private final Integer sellerUserId;
    private final Integer categoryId;
    private final String regionName;
    private final Integer measureUnitId;
    private final Boolean isActive;
    private final LocalDate dateAdded;
    private final String status;

}
