package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.RegisterRequest;
import com.teamProject.backJagaAeda.application.login.UserMapper;
import com.teamProject.backJagaAeda.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleService roleService;


    public User getValidUser(String userName, String password) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
        ValidationService.validateUserExists(user);
        return user.get();
    }

    public User createAndAddNewUser(RegisterRequest request) {
        boolean userExists = userRepository.existsByUserName(request.getUserName());
        ValidationService.validateUserNameExists(userExists, request.getUserName());

        User user = userMapper.registerRequestToUser(request);
        Role role = roleService.getRoleUser();
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        ValidationService.validateUserExists(user);
        return user.get();
    }
    //    public RegisterResponse mapRequestAndAddUser(RegisterRequest request, Contact contact) {
//        User user = userMapper.registerRequestToUser(request);
//        user.setContact(contact);
//        userRepository.save(user);
//        return userMapper.userToUserResponse;
//    }
}
