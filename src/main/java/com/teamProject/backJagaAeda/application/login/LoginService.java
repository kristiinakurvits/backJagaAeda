package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    public LogInResponse logIn(LogInRequest request) {
        return userService.logIn(request);


        // TODO: Get valid user
        // TODO: UserService leia valiidne kasutaja userservice -> userrepository kaudu
        // TODO: See tulemus peab olema optional klassi sees
        // TODO: Kasutades validationservicet teete uue meetodi, mis kontrollib, kas see optional user isempty
        //  kui on empty, throw businesserror
        //  kui validatsioonis viga ei tulnud, siis returni selle meetodi sees sellest optional user objektist geti abil user
        // TODO: M2pi saadud user LogInResponseks, returni see tulemus
        // TODO:

    }
}

