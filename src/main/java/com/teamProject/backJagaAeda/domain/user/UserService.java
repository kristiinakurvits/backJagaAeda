package com.teamProject.backJagaAeda.domain.user;

import com.teamProject.backJagaAeda.application.login.LogInRequest;
import com.teamProject.backJagaAeda.application.login.LogInResponse;
import com.teamProject.backJagaAeda.application.login.UserMapper;
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
// kokk ei too koju kohale, igal klassil on oma vastutusala, mis siis moodustab kihid
//    }
    public Optional<User> getUser(String userName, String password) {
        User user= userRepository.findByUserNameAndPassword(userName, password);
        return Optional.ofNullable(user);
    }

}
