package com.teamProject.backJagaAeda.application.login;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContactInfo implements Serializable {
    private Integer contactId;
    private Integer userId;
    private String userName;
    private String eMail;
    private String firstName;
    private String lastName;
    private String mobile;
    private List<LocationInfo> locations;

}
