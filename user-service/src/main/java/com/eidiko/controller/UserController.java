package com.eidiko.controller;

import com.eidiko.dto.SaveUserRequestDTO;
import com.eidiko.dto.UserDTO;
import com.eidiko.model.UserEntity;
import com.eidiko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody SaveUserRequestDTO request) {
        UserEntity user = modelMapper.map(request, UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public UserDTO getUser(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

}
