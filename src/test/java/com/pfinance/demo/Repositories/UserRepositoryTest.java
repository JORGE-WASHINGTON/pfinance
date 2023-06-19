package com.pfinance.demo.Repositories;

import com.pfinance.demo.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveNewUser(){
        //Given
        User newUser = new User("jorge", "jorge", "morais", "1234", "@gmail");
        //when
        User savedUser = userRepository.save(newUser);
        //then
        assertNotNull(savedUser.getId());
    }

    @Test
    void shouldRetrieveAllUsers(){
        //Given
        User newUser1 = new User("jorge", "jorge", "morais", "1234", "@gmail");
        User newUser2 = new User("jorge", "jorge", "morais", "1234", "@gmail");
        User newUser3 = new User("jorge", "jorge", "morais", "1234", "@gmail");
        userRepository.save(newUser1);
        userRepository.save(newUser2);
        userRepository.save(newUser3);
        //when
        List<User> retrievedUsers = userRepository.findAll();
        //then
        assertEquals(retrievedUsers.size(), 3);
    }
}