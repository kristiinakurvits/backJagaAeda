package com.teamProject.backJagaAeda.application.login;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LogInRequest implements Serializable {
    @NotNull
    private final String userName;
    @NotNull
    private final String password;
}
