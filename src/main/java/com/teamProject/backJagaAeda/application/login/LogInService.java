package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogInService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    public LogInResponse logIn(LogInRequest request) {
        User user = userService.getValidUser(request.getUserName(), request.getPassword());
        return userMapper.userToLogInResponse(user);
    }

    public LogInResponse register(RegisterRequest request) {
        return null;
    }


}

