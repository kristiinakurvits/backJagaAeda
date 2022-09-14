package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.ContactInfo;
import com.teamProject.backJagaAeda.application.login.UserMapper;
import com.teamProject.backJagaAeda.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;

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
        Contact contact = contactMapper.contactInfoToContact(request);
        User user = getValidUser(request.getUserId());
        contact.setUser(user);
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setMobile(request.getMobile());
        //Location location = contactMapper.locationInfoToContact(contactId)
        Location location = contactMapper.contactInfoToLocation(request);
        location.setName();


        contactRepository.save(contact);

        // TODO: 13.09.2022 ContacInfo 'Dto'
        // TODO: 13.09.2022 tuleb saaata nii
    }
}
