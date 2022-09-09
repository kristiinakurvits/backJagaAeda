package com.teamProject.backJagaAeda.application.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private final Integer id;
    private final Integer roleId;
    private final String roleName;
    private final String userName;
    private final String password;
}
