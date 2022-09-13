package com.teamProject.backJagaAeda.application.login;


import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterResponse implements Serializable {
    private Integer userId;
    private Integer roleId;
}
