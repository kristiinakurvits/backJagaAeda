package com.teamProject.backJagaAeda.application.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogInRequest implements Serializable {
    private final String userName;
    private final String password;
}
