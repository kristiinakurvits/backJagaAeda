package com.teamProject.backJagaAeda.domain.user.region;

import com.teamProject.backJagaAeda.application.dropdown.RegionDto;
import com.teamProject.backJagaAeda.domain.user.region.Region;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegionMapper {

    @Mapping(source = "id", target = "regionId")
    @Mapping(source = "county", target = "name")
    RegionDto regionToRegionDto(Region region);

    List<RegionDto> categoriesToCategoryDtos(List<Region> regions);
}

