package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "measureUnitId", target = "measureUnit.id")
    @Mapping(source = "regionName", target= "location.id")
    Product productRequestToProduct(ProductRequest productRequest);

    @Mapping(source = "sellerUser.id", target = "sellerUserId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    ProductResponse productToProductResponse(Product product);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "sellerUser.id", target = "sellerUserId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "measureUnit.unit", target = "measureUnit")
//    @Mapping(source = "imageBase64", target = "imageBase64", qualifiedByName = "byteArrayToString")
    @Mapping(target = "imageBase64", ignore = true)
    @Mapping(source = "location.id", target= "regionName")
    @Mapping(source = "category.id", target = "categoryId")
    ProductInfo productsToProductInfo(Product product);

    List<ProductInfo> productsToProductInfos(List<Product> products);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] imageBase64) {
        return new String(imageBase64);
    }
}
