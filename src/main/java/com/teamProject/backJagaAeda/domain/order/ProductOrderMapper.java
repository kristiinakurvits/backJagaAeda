package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)

public interface ProductOrderMapper {

    List<ProductInfo> productsToProductInfos(List<ProductOrder> products);

    @Mapping(source = "id", target = "productOrderId")
    @Mapping(source = "product.sellerUser.id", target = "sellerUserId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.quantity", target = "quantity")
    @Mapping(source = "product.measureUnit.unit", target = "measureUnit")
    @Mapping(source = "product.imageBase64", target = "imageBase64", qualifiedByName = "byteArrayToString")
    @Mapping(source = "product.location.region.county", target = "regionName")
    @Mapping(source = "product.location.address", target = "address")
    @Mapping(source = "product.category.id", target = "categoryId")
    ProductInfo productOrderToProductInfo(ProductOrder productOrder);


    List<ProductInfo> productOrdersToProductInfos(List<ProductOrder> productOrders);


    @Named("byteArrayToString")
    default String byteArrayToString(byte[] imageBase64) {
        return imageBase64 == null ? null : new String(imageBase64);
    }

    @Named("stringToByteArray")
    default byte[] stringToByteArray(String base64AsString) {
        return  base64AsString == null ? null :  base64AsString.getBytes(StandardCharsets.UTF_8);
    }
}
