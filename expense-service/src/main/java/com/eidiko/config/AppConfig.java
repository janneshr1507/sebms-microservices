package com.eidiko.config;

import com.eidiko.dto.SaveExpenseRequestDTO;
import com.eidiko.model.Expense;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        //ModelMapper mapper = new ModelMapper();
        return new ModelMapper();
    }
}
