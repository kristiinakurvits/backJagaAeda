package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface ProductOrderMapper {

    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);
}
