package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.application.product.ProductInfo;
import com.teamProject.backJagaAeda.application.product.ProductRequest;
import com.teamProject.backJagaAeda.application.product.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "measureUnitId", target = "measureUnit.id")
    @Mapping(source = "locationId", target = "location.id")
    Product productRequestToProduct(ProductRequest productRequest);

    @Mapping(source = "sellerUser.id", target = "sellerUserId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    @Mapping(source = "location.region.county", target = "regionName")
    ProductResponse productToProductResponse(Product product);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "sellerUser.id", target = "sellerUserId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "measureUnit.unit", target = "measureUnit")
//    @Mapping(source = "imageBase64", target = "imageBase64", qualifiedByName = "byteArrayToString")
    @Mapping(ignore = true, target = "imageBase64")
    @Mapping(source = "location.region.county", target = "regionName")
    @Mapping(source = "category.id", target = "categoryId")
    ProductInfo productsToProductInfo(Product product);

    List<ProductInfo> productsToProductInfos(List<Product> products);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] imageBase64) {
        return new String(imageBase64);
    }

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    @Mapping(source = "sellerUser.id", target = "userId")
    @Mapping(source = "sellerUser.userName",target = "userName")
    @Mapping(source = "category.name",target = "categoryName")
    @Mapping(source = "location.region.county",target = "regionName")
    ProductRequest productToProductRequest(Product product);
}
