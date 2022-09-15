package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.ContactInfo;
import com.teamProject.backJagaAeda.application.login.LocationRequest;
import com.teamProject.backJagaAeda.application.login.UserMapper;
import com.teamProject.backJagaAeda.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;
    @Resource
    private RegionRepository regionRepository;

    @Resource
    private LocationMapper locationMapper;
    @Resource
    private LocationRepository locationRepository;


    public User getValidUser(String userName, String password) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
        ValidationService.validateUserExists(user);
        return user.get();
    }

    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        ValidationService.validateUserExists(user);
        return user.get();
    }

    public void updateContactDetail(ContactInfo request) {
        Contact contact = contactRepository.findById(request.getContactId()).get();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setMobile(request.getMobile());
        contactRepository.save(contact);
    }

    public void addAddress(LocationRequest request) {
// TODO: 15.09.2022 mäppime requestist location objekti niipalju andmeid kui saab
// TODO: 15.09.2022

        Location location = locationMapper.locatioRequestToLocation(request);

/*
        // MAPPER teeb seda
        Location location1 = new Location();
        location1.setAddress(request.getAddress());
        location1.setName(request.getLocationName());
*/
        Contact contact = contactRepository.findById(request.getContactId()).get();
        Region region = regionRepository.findById(request.getRegionId()).get();
        location.setContact(contact);
        location.setRegion(region);
        locationRepository.save(location);

    }


    public ContactInfo findContactDetail(Integer contactId) {
        Contact contact = contactRepository.findById(contactId).get();
        // TODO: 15.09.2022 (mäpper lõpeteda)
        return contactMapper.contactToContactInfo(contact);
    }

    public List<LocationRequest> findContactLocationsByContactId(Integer contactId) {
//        List<Location> locations = locationRepository.findContactLocationsByContactId(contactId);
        // TODO: 15.09.2022 mäppida andmed ->  List<LocationRequest>
        return null;
    }
}
