package com.teamProject.backJagaAeda.application.login;

import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    public LogInResponse logIn(LogInRequest request) {
        Optional<User> user = userService.getUser(request.getUserName(), request.getPassword());
        // getValid user validationservice abil, kui see ei eksisteeri, tuleb visata error, kui l'heb edasi, sisi tagastan loginRespose, kus on userilt ID sisse m2pitud
        return null;
    }

    public LogInResponse register(RegisterRequest request) {
        return null;
    }


    // TODO: Get valid user
    // TODO: UserService leia valiidne kasutaja userservice -> userrepository kaudu
    // TODO: See tulemus peab olema optional klassi sees
    // TODO: Kasutades validationservicet teete uue meetodi, mis kontrollib, kas see optional user isempty
    //  kui on empty, throw businesserror
    //  kui validatsioonis viga ei tulnud, siis returni selle meetodi sees sellest optional user objektist geti abil user
    // TODO: M2pi saadud user LogInResponseks, returni see tulemus
    // TODO:


}

