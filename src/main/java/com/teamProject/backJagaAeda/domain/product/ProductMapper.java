package com.teamProject.backJagaAeda.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper (unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface ProductMapper {

//    @Mapping(target = "id", ignore = true)
    List<ProductInfo> productsToProductInfos(List<Product> products);
}
