package com.eidiko.controller;

import com.eidiko.dto.SaveExpenseRequestDTO;
import com.eidiko.dto.SaveExpenseResponseDTO;
import com.eidiko.model.Expense;
import com.eidiko.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/saveExpense")
    public SaveExpenseResponseDTO saveExpense(@Valid @RequestBody SaveExpenseRequestDTO request) {
        return expenseService.saveExpense(request);
    }

    @GetMapping("/getExpense")
    public SaveExpenseResponseDTO getExpense(@RequestParam("id") Long id) {
        return expenseService.getExpense(id);
    }
}
