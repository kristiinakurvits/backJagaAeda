package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import com.teamProject.backJagaAeda.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface OrderMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.sellerUser.id", target = "sellerUserId")
    @Mapping(source = "product.name", target ="productName")
    @Mapping(source = "product.measureUnit.unit", target = "measureUnit")
////    @Mapping(source = "imageBase64", target = "imageBase64", qualifiedByName = "byteArrayToString")
    @Mapping(ignore = true, target = "imageBase64")
    @Mapping(source = "product.location.id", target = "regionName")
    @Mapping(source = "product.category.id", target = "categoryId")
    ProductInfo productsToProductInfos(ProductOrder product);
    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);
}
