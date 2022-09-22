package com.teamProject.backJagaAeda.application.order;

import lombok.Data;

@Data
public class CartItem {
    private String productOrderId;
    private String productId;
    private String productName;
    private String sellerUserName;
    private Integer quantity;
    private String measureUnit;
    private String imageBase64;
    private String regionName;
    private String address;
}
