package com.teamProject.backJagaAeda.domain.user.region;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RegionService {

    @Resource
    private RegionRepository regionRepository;
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
