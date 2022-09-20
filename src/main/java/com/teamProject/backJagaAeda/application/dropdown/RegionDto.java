package com.teamProject.backJagaAeda.application.dropdown;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.teamProject.backJagaAeda.domain.user.region.Region} entity
 */
@Data
public class RegionDto implements Serializable {
    private final Integer regionId;
    private final String name;
}