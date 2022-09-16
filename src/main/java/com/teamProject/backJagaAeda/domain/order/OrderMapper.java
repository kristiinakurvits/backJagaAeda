package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.order.OrderInfo;
import com.teamProject.backJagaAeda.application.product.ProductInfo;
import com.teamProject.backJagaAeda.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface OrderMapper {

    @Mapping(source = "buyerUser.id", target = "buyerUserId")
    OrderInfo orderToOrderInfo(Order order);

    List<OrderInfo> orderToOrderInfos(List<Order> order);
}
