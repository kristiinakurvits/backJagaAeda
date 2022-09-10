package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.LogInRequest;
import com.teamProject.backJagaAeda.application.login.LogInResponse;
import com.teamProject.backJagaAeda.application.login.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public LogInResponse logIn(LogInRequest request) {
        User user = userMapper.loginRequestToUser(request);
        User userExsists = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        return userMapper.userExistsToLogInResponse(userExsists);

    }
}
