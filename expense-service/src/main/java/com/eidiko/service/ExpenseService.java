package com.eidiko.service;

import com.eidiko.client.UserClient;
import com.eidiko.dto.SaveExpenseRequestDTO;
import com.eidiko.dto.SaveExpenseResponseDTO;
import com.eidiko.exception.ExpenseNotFoundException;
import com.eidiko.exception.UserNotFoundException;
import com.eidiko.model.Expense;
import com.eidiko.repository.ExpenseRepository;
import feign.FeignException.NotFound;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final ModelMapper modelMapper;
    private final UserClient userClient;

    public SaveExpenseResponseDTO saveExpense(SaveExpenseRequestDTO request) {
        Long id = request.getUserId();
        try {
            userClient.getUser(id);
        } catch(NotFound e) {
            throw new UserNotFoundException("Kindly provide valid userId in the request body");
        }
        Expense expense = new Expense();
        expense.setUserId(request.getUserId());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        return modelMapper.map(expenseRepo.save(expense), SaveExpenseResponseDTO.class);
    }

    public SaveExpenseResponseDTO getExpense(Long id) {
        Expense expense = expenseRepo.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with the id: " + id));

        return modelMapper.map(expense, SaveExpenseResponseDTO.class);
    }

    public SaveExpenseResponseDTO[] getExpensesByUserId(Long userId) {
        List<Expense> list = expenseRepo.findByUserId(userId);
        SaveExpenseResponseDTO[] response = list.stream()
                .map(expense -> modelMapper.map(expense, SaveExpenseResponseDTO.class))
                .toArray(SaveExpenseResponseDTO[]::new);

        return response;
    }

    public void deleteExpense(Long id) {
        if(!expenseRepo.existsById(id)) {
            throw new ExpenseNotFoundException("Expense not found with the id: " + id);
        }
        expenseRepo.deleteById(id);
    }
}
