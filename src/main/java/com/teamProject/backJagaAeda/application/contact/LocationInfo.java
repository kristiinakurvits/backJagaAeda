package com.teamProject.backJagaAeda.application.contact;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.teamProject.backJagaAeda.domain.user.location.Location} entity
 */
@Data
public class LocationInfo implements Serializable {
    private Integer locationId;
    private Integer regionId;
    private String locationName;
    private String address;
}