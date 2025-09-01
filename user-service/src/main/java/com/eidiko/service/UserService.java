package com.eidiko.service;

import com.eidiko.dto.UserDTO;
import com.eidiko.exception.UserNotFoundException;
import com.eidiko.model.UserEntity;
import com.eidiko.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

    public UserDTO saveUser(UserEntity user) {
        UserEntity response = userRepo.save(user);
        return modelMapper.map(response, UserDTO.class);
    }

    public UserDTO getUser(Long id) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with the id: " + id));
        return modelMapper.map(user, UserDTO.class);
    }
}
