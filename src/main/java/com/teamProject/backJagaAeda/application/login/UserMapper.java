package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.control.MappingControl;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    LogInResponse userToLogInResponse(User user);

    User registerRequestToUser(RegisterRequest request);


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "contact.id", target = "contactId")
    @Mapping(source = "contact.firstName", target = "firstName")
    @Mapping(source = "contact.lastName", target = "lastName")
    @Mapping(source = "contact.eMail", target = "eMail")
    @Mapping(source = "contact.userName", target = "userName")
    @Mapping(source = "contact.password", target = "password")
    @Mapping(source = "contact.mobile", target = "mobile")
    ContactInfo userToContactInfo(User user);


}
