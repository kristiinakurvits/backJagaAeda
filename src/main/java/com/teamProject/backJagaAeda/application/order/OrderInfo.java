package com.teamProject.backJagaAeda.application.order;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OrderInfo implements Serializable {
    private final Integer orderId;
    private final Integer buyerUserId;
    private final String buyerUserUserName;
    private final String buyerUserPassword;
    private final String status;
    private final Instant dateTime;
}
