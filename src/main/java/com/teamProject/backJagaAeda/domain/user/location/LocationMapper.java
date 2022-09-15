package com.teamProject.backJagaAeda.domain.user.location;

import com.teamProject.backJagaAeda.application.contact.LocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    // TODO: INDREK MÄPPER
    Location locationRequestToLocation(LocationRequest request);
}
