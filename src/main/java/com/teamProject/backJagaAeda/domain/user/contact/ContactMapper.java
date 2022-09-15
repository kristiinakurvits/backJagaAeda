package com.teamProject.backJagaAeda.domain.user.contact;

import com.teamProject.backJagaAeda.application.contact.ContactInfo;
import com.teamProject.backJagaAeda.application.login.RegisterRequest;
import com.teamProject.backJagaAeda.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import javax.persistence.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "id", target = "contactId")
    @Mapping(source = "user.userName", target = "userName")
    ContactInfo contactToContactInfo(Contact contact);

    Contact registerRequestToContact(RegisterRequest request);
}