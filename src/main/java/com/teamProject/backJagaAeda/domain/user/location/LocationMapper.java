package com.teamProject.backJagaAeda.domain.user.location;

import com.teamProject.backJagaAeda.application.contact.LocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "address", target = "address")
    @Mapping(source = "locationName", target = "name")
    Location locationRequestToLocation(LocationRequest request);
}
