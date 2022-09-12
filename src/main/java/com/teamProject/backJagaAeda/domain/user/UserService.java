package com.teamProject.backJagaAeda.domain.user;

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
    private UserRepository userRepository;

//    public LogInResponse logIn(LogInRequest request) {
//        User user = userMapper.loginRequestToUser(request);
//        User userExsists = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
//        return userMapper.userExistsToLogInResponse(userExsists);
// nt restorani puhul kokk ei too koju kohale, igal klassil on oma vastutusala, mis siis moodustab kihid
//    }

    public User getValidUser(String userName, String password) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
        ValidationService.validateUserExists(user);
        return user.get();
    }



}
