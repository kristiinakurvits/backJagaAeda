package com.teamProject.backJagaAeda.application.dropdown;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.teamProject.backJagaAeda.domain.user.location.Location} entity
 */
@Data
public class LocationDto implements Serializable {
    private final Integer locationId;
    private final String locationName;
}