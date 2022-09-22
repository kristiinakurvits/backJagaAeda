package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.order.CartItem;
import com.teamProject.backJagaAeda.application.product.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface ProductOrderMapper {

    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);

    @Mapping(source = "id", target = "productOrderId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.sellerUser.userName", target = "sellerUserName")
    @Mapping(source = "product.quantity", target = "quantity")
    @Mapping(source = "product.measureUnit.unit", target = "measureUnit")
    @Mapping(ignore = true, target = "imageBase64")
    @Mapping(source = "product.location.region.county", target = "regionName")
    @Mapping(source = "product.location.address", target = "address")
    CartItem productOrderToCartItem(ProductOrder productOrder);

    List<CartItem> productOrdersToCartItems(List<ProductOrder> productOrders);
}
