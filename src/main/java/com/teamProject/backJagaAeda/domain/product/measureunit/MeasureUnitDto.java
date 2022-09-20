package com.teamProject.backJagaAeda.domain.product.measureunit;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link MeasureUnit} entity
 */
@Data
public class MeasureUnitDto implements Serializable {
    private final Integer measureUnitId;
    private final String unitName;
}