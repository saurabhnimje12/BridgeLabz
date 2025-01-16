package com.example.client;

import com.example.external.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "CART-API")
public interface CartClient {
    @GetMapping("/cartApi/getAllCartById")
    List<Cart> cartsList(@RequestHeader("Authorization") String role, @RequestHeader("Authorization") String authorization);
}
