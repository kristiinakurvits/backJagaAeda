package com.teamProject.backJagaAeda.application.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartInfo implements Serializable {
    private Integer orderId;
    private Integer productId;
    private Integer buyerUserId;
    private Boolean orderHasStarted;

}
