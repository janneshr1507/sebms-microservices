package com.eidiko.client;

import com.eidiko.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/getUser")
    UserDTO getUser(@RequestParam("id") Long id);
}
