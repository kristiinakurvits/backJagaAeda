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

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "password", target = "password")
    User registerRequestToUser(RegisterRequest request);


}
