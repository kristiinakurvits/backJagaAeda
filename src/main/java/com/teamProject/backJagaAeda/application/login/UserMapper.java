package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target= "userId")
    @Mapping(source = "role.id", target= "roleId")
    LogInResponse userToLogInResponse(User user);
}
