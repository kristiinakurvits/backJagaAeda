package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = Instant.class)
public interface ContactMapper {

//    @Mapping(source = "firstName", target = "firstName")
//    @Mapping(source = "lastName", target = "lastName")
//    @Mapping(source = "mobile", target = "mobile")
        // List<LocationInfo> locations;
    Contact contactInfoToContact(ContactInfo request);


    @Mapping(source = "locations", target = "address")
    @Mapping(source = "locations", target = "name")
    Location contactInfoToLocation(ContactInfo request);
}
