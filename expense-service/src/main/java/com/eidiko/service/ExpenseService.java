package com.eidiko.service;

import com.eidiko.client.UserClient;
import com.eidiko.dto.UserDTO;
import com.eidiko.exception.UserNotFoundException;
import com.eidiko.model.Expense;
import com.eidiko.repository.ExpenseRepository;
import feign.FeignException.NotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final UserClient userClient;

    public Expense saveExpense(Expense expense) {
        Long id = expense.getUserId();
        try {
            UserDTO user = userClient.getUser(id);
        } catch(NotFound e) {
            throw new UserNotFoundException("Kindly provide userId in the request body");
        }
        return expenseRepo.save(expense);
    }
}
