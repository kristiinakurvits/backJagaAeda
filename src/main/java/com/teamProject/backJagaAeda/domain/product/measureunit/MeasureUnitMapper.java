package com.teamProject.backJagaAeda.domain.product.measureunit;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MeasureUnitMapper {

@Mapping(source = "id", target = "measureUnitId")
@Mapping(source = "unit", target = "unitName")
    MeasureUnitDto measureUnitToMeasureUnitDto(MeasureUnit measureUnit);

    List<MeasureUnitDto> measureUnitToMeasureUnitDtos(List<MeasureUnit> measureUnits);


}
