package com.burak.movieapp.service;

import com.burak.movieapp.model.User;
import com.burak.movieapp.model.dto.UserDTO;
import com.burak.movieapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(this::userDtoBuilder)
                .collect(Collectors.toList());
    }
    public UserDTO saveUser(User user){
        userRepository.save(user);
        return userDtoBuilder(user);
    }
    private UserDTO userDtoBuilder(User user){
        return UserDTO.builder()
                .Id(user.getId())
                .commentList(user.getCommentList())
                .username(user.getUsername())
                .build();
    }
}
