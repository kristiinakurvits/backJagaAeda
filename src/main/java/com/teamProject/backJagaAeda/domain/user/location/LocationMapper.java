package com.teamProject.backJagaAeda.domain.user.location;

import com.teamProject.backJagaAeda.application.contact.LocationInfo;
import com.teamProject.backJagaAeda.application.contact.LocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "locationName", target = "name")
    Location locationRequestToLocation(LocationRequest request);

    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "region.id", target = "regionId")
    @Mapping(source = "contact.id", target = "contactId")
    @Mapping(source = "id", target = "locationId")
    LocationRequest locationToContactRequest(Location location);

    List<LocationRequest> locationsToLocationRequest(List<Location> locations);
}
