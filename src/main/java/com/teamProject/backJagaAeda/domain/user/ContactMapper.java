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

    //    List<ContactInfo> contactsToContactInfos(List<Contact> contacts);
    @Mapping(source = "userName", target = "user.userName")
    @Mapping(source = "password", target = "user.password")
    Contact RegisterRequestToContact(RegisterRequest request);



//    Contact userRequestToContact(RegisterRequest request);
}
