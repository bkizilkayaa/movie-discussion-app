package com.burak.movieapp.controller;


import com.burak.movieapp.model.User;
import com.burak.movieapp.model.dto.UserDTO;
import com.burak.movieapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody User newUser){
        return new ResponseEntity<>(userService.saveUser(newUser),HttpStatus.CREATED);
    }
}
