package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

//    @Mapping(source = "id", target = "userId")
//    @Mapping(source = "userName", target = "userUserName")
//    @Mapping(source = "password", target = "userPassword")

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "userUserName", target = "userName")
    @Mapping(source = "userPassword", target = "password")

    ContactInfo contactToContactInfo(User user);



}
