package com.eidiko.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class SaveExpenseRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal amount;

    @Size(max = 200)
    private String description;
}
