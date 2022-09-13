package com.teamProject.backJagaAeda.application.login;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String eMail;
    @NotNull
    private String mobile;
    @NotNull
    private String userName;
    @NotNull
    private String password;

}
