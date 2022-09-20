package com.teamProject.backJagaAeda.domain.product.measureunit;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeasureUnitService {
    @Resource
    private MeasureUnitRepository measureUnitRepository;
    public List<MeasureUnit> getAllMeasureUnits() {
        return measureUnitRepository.findAll();

    }
}
