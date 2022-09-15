package com.teamProject.backJagaAeda.application.contact;

import lombok.Data;

@Data
public class LocationRequest {
    private Integer contactId;
    private Integer regionId;
    private String address;
    private String locationName;
}
