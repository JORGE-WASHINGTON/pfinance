package com.pfinance.demo.Controllers;

import com.pfinance.demo.DTO.CreateUserRequestDTO;
import com.pfinance.demo.Entities.User;
import com.pfinance.demo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/users")
    ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO){
        User createdUser = userService.createUser(createUserRequestDTO);
        return ResponseEntity.ok().body(createdUser);
    }
}
