package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LogInService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;


    @Transactional
    public RegisterResponse registerNewUser(RegisterRequest request) {
        User user = userService.createAndAddNewUser(request);
        Contact contact = contactService.registerRequestToContact(request);
        contact.setUser(user);
        return userMapper.userToRegisterResponse(user);
    }


    public LogInResponse logIn(LogInRequest request) {
        User user = userService.getValidUser(request.getUserName(), request.getPassword());
        return userMapper.userToLogInResponse(user);

    }

}

