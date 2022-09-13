package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.Contact;
import com.teamProject.backJagaAeda.domain.user.ContactService;
import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LogInService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;


    @Transactional
    public RegisterResponse registerNewUser(RegisterRequest request) {
        Contact contact = contactService.addContact(request);
        return userService.mapRequestAndAddUser(request, contact);
    }


    public LogInResponse logIn(LogInRequest request) {
        User user = userService.getValidUser(request.getUserName(), request.getPassword());
        return userMapper.userToLogInResponse(user);

    }



}

