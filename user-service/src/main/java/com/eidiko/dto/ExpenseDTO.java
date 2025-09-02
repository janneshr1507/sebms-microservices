package com.eidiko.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
public class ExpenseDTO {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
