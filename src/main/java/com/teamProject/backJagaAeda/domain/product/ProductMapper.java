package com.teamProject.backJagaAeda.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "categoryName", target = "category.name")
    @Mapping(source = "measureUnitUnit", target = "measureUnit.id")
    ProductResponse productRequestToProduct(Product product);
}
