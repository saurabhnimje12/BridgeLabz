package com.example.controller;

import com.example.dto.DtoToOrderEntity;
import com.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderApi")
public class OrderJwtController {
    private OrderService orderService;

    public OrderJwtController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orderPlace")
    public ResponseEntity<String> placeOrder(@RequestAttribute("role") String role, @RequestHeader("Authorization") String authorization, @RequestBody DtoToOrderEntity dtoToCartEntity) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(orderService.placeOrder(authorization,dtoToCartEntity), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Add To Cart Book!!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@RequestAttribute("role") String role, @RequestHeader("Authorization") String authorization, @PathVariable Long orderId){
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(orderService.cancelOrder(authorization, orderId), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Cancel Order from Cart!!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders(@RequestAttribute("role") String role){
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Get All Cart!!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOrdersForUser")
    public ResponseEntity<?> getAllOrdersForUser(@RequestAttribute("role") String role, @RequestHeader("Authorization") String authorization){
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<>(orderService.getAllOrdersForUser(authorization), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Get Cart!!", HttpStatus.NOT_FOUND);
        }
    }
}
