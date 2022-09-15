package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.ContactInfo;
import com.teamProject.backJagaAeda.application.login.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    // TODO: INDREK tee mäping
    @Mapping(source = "id", target = "contactId")
    ContactInfo contactToContactInfo(Contact contact);

    Contact registerRequestToContact(RegisterRequest request);
}