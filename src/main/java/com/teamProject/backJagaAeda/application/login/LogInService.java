package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LogInService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private LogInResponse logInResponse;


    public LogInResponse logIn(LogInRequest request) {
        Optional<User> user = userService.getUser(request.getUserName(), request.getPassword());
        LogInResponse logInResponse = userMapper.loginRequestToUser(getUser());
        User user = userService.getValidUser(request.getUserId());
        return logInResponse;

    }
    public LogInResponse register(RegisterRequest request) {
        return null;
    }


    // TODO: Get valid user
    // TODO: Userservice leia valiidne kasutaja userservice -> userrepository kaudu
    // TODO: See tulemus peab olema optional klassi sees
    // TODO: Kasutades validationservicet teete uue meetodi, mis kontrollib, kas see optional user isEmpty
    //  kui on empty, throw businesserror
    //  kui validatsioonis viga ei tulnud, siis returni selle meetodi sees sellest optional user objektist geti abil user
    // TODO: Mäpi saadud user LogInResponseks, returni see tulemus


}

