package com.teamProject.backJagaAeda.domain.user.location;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(Integer userId) {
        return locationRepository.findAllBy(userId);
    }
}
