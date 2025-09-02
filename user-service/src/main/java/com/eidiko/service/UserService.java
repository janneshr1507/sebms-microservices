package com.eidiko.service;

import com.eidiko.dto.SaveUserRequestDTO;
import com.eidiko.dto.UserDTO;
import com.eidiko.exception.UserAlreadyExistsException;
import com.eidiko.exception.UserNotFoundException;
import com.eidiko.model.UserEntity;
import com.eidiko.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO saveUser(SaveUserRequestDTO request) {

        if(userRepo.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already exists with the email: " + request.getEmail());
        } else if(userRepo.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("User already exists with the username: " + request.getUsername());
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        UserEntity response = userRepo.save(user);
        return modelMapper.map(response, UserDTO.class);
    }

    public UserDTO getUser(Long id) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with the id: " + id));
        return modelMapper.map(user, UserDTO.class);
    }
}
