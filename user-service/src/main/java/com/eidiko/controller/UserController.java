package com.eidiko.controller;

import com.eidiko.dto.SaveUserRequestDTO;
import com.eidiko.dto.UserDTO;
import com.eidiko.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

}
