package com.pfinance.demo.Services;

import com.pfinance.demo.DTO.CreateUserRequestDTO;
import com.pfinance.demo.Entities.User;
import com.pfinance.demo.Mappers.UserMapper;
import com.pfinance.demo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(CreateUserRequestDTO createUserRequestDTO){
        return userRepository.save(userMapper.UserDtotoUser(createUserRequestDTO));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
