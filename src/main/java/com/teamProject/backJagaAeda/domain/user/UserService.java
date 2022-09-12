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

    public User getValidUser(String userName, String password) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
        ValidationService.validateUserExists(user);
        return user.get();
    }

    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        ValidationService.validateUserExists(user);
        return user.get();
    }
}
