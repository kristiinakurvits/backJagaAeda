package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.ContactInfo;
import com.teamProject.backJagaAeda.application.login.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "id", target = "contactId")
    ContactInfo contactToContactInfo(Contact contact);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
//    @Mapping(source = "eMail", target = "eMail")
    @Mapping(source = "mobile", target = "mobile")
    Contact registerRequestToContact(RegisterRequest request);
}