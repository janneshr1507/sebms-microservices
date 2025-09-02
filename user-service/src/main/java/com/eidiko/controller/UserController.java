package com.eidiko.controller;

import com.eidiko.dto.SaveUserRequestDTO;
import com.eidiko.dto.UserDTO;
import com.eidiko.model.UserEntity;
import com.eidiko.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public UserDTO saveUser(@Valid @RequestBody SaveUserRequestDTO request) {
        return userService.saveUser(request);
    }

    @GetMapping("/getUser")
    public UserDTO getUser(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

}
