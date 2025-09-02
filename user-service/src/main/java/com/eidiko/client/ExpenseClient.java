package com.eidiko.client;

import com.eidiko.dto.ExpenseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "expense-service")
public interface ExpenseClient {

    @GetMapping("/getExpensesByUserId")
    ExpenseDTO[] getExpensesByUserId(@RequestParam("userId") Long userId);

    @DeleteMapping("/deleteExpense")
    void deleteExpense(@RequestParam("id") Long id);

}
