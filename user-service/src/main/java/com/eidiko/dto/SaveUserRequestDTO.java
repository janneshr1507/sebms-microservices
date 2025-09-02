package com.eidiko.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveUserRequestDTO {

    @NotBlank
    @Size(min = 8)
    private String username;

    @NotBlank
    @Size(min = 12, max =18)
    private String password;

    @Email
    @Size(min = 12)
    private String email;

}
