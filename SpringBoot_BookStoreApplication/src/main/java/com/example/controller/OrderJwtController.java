package com.example.controller;

import com.example.dto.DtoToOrderEntity;
import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderApi")
public class OrderJwtController {
    private OrderService orderService;

    public OrderJwtController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orderPlace")
    public ResponseEntity<String> placeOrder(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId, @RequestBody DtoToOrderEntity dtoToCartEntity) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(orderService.placeOrder(userId,dtoToCartEntity), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Add To Cart Book!!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId, @PathVariable Long orderId){
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(orderService.cancelOrder(userId, orderId), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Cancel Order from Cart!!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId){
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<>(orderService.getAllOrders(userId), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Get All Cart!!", HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/getAllOrdersForUser")
//    public ResponseEntity<?> getAllOrdersForUser(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId){
//        if ("USER".equalsIgnoreCase(role)) {
//            return new ResponseEntity<>(orderService.getAllOrdersForUser(userId), HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<String>("Token is NOT Valid to Get Cart!!", HttpStatus.NOT_FOUND);
//        }
//    }


}
