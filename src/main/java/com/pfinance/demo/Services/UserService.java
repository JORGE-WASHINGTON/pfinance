package com.pfinance.demo.Services;

import com.pfinance.demo.Entities.User;
import com.pfinance.demo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
