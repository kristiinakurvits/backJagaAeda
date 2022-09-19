package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import com.teamProject.backJagaAeda.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface ProductOrderMapper {

    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);

    @Mapping(source = "product.id", target = "productId")
    ProductInfo productOrderToProductInfos(ProductOrder productOrder);

    List<ProductInfo> productOrdersToProductInfos(List<ProductOrder> productOrders);
}
