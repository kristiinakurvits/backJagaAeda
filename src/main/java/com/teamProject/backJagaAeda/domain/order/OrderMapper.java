package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.domain.product.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface OrderMapper {

    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);
}