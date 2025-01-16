package com.example.client;

import com.example.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "USER-API")
public interface UserClient {
    @GetMapping("/user/Api/getUser")
    User getUser(@RequestHeader("Authorization") String authorization);

    @GetMapping("/user/test_UserApi")
    String testUserApi();
}
