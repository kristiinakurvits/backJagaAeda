package com.teamProject.backJagaAeda.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "measureUnitId", target = "measureUnit.id")
    Product productRequestToProduct(ProductRequest productRequest);


    @Mapping(source = "sellerUser.id", target = "sellerUserId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    ProductResponse productToProductResponse(Product product);

    @Mapping(source = "sellerUser.id" , target = "sellerUserId")
    @Mapping(source = "category.id" , target = "categoryId")
    @Mapping(source = "measureUnit.id" , target = "measureUnitId")
    ProductInfo mapProductsToProductInfos(Product products);
}
