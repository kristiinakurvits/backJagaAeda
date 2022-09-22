package com.teamProject.backJagaAeda.domain.user.location;

import com.teamProject.backJagaAeda.application.contact.LocationInfo;
import com.teamProject.backJagaAeda.application.contact.LocationRequest;
import com.teamProject.backJagaAeda.application.dropdown.LocationDto;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnit;
import com.teamProject.backJagaAeda.domain.product.measureunit.MeasureUnitDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "locationName", target = "name")
    Location locationRequestToLocation(LocationRequest request);

    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "region.id", target = "regionId")
    LocationRequest locationToContactRequest(Location location);

    List<LocationRequest> locationsToLocationRequest(List<Location> locations);

    @Mapping(source="id", target = "locationId")
    @Mapping(source="name", target = "locationName")
    LocationDto locationToLocationDto(Location location);
    List<LocationDto> locationToLocationDtos(List<Location> locations);

}
