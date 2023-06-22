package com.pfinance.demo.Services;

import com.pfinance.demo.DTO.CreateUserRequestDTO;
import com.pfinance.demo.Entities.User;
import com.pfinance.demo.Mappers.UserMapper;
import com.pfinance.demo.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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
        try {
            return userRepository.save(userMapper.UserDtotoUser(createUserRequestDTO));
        } catch (Exception ex) {
            throw ex;
        }

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        try {
            return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        } catch (EntityNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            System.out.println("An error occurred while retrieving the user: " + ex.getMessage());
        }
        return null;
    }

}
