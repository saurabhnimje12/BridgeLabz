package com.example.controller;

import com.example.dto.CartEntityToDto;
import com.example.dto.DtoToCartEntity;
import com.example.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartApi")
public class CartJwtController {
    private CartService cartService;

    public CartJwtController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart/{bookId}")
    public ResponseEntity<String> addToCart(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId, @PathVariable Long bookId, @RequestBody DtoToCartEntity dtoToCartEntity) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(cartService.addToCart(userId, bookId, dtoToCartEntity), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Add To Cart Book", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/removeFromCart/{cartId}")
    public ResponseEntity<String> removeFromCart(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId, @PathVariable Long cartId) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(cartService.removeFromCart(userId, cartId), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Remove From Cart ", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/removeByUserID")
    public ResponseEntity<String> removeByUserID(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(cartService.removeByUserID(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Remove From Cart ", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateCart/{cartId}/{quantity}")
    public ResponseEntity<String> updateQuantityInCart(@RequestAttribute("role") String role, @RequestAttribute("userId") long userId, @PathVariable Long cartId, @PathVariable Integer quantity) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(cartService.updateQuantityInCart(userId, cartId, quantity), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Update the Cart ", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCartById")
    public ResponseEntity<?> getAllCartItemsByUserID(@RequestAttribute("role") String role, @RequestAttribute("userId") Long userId) {
        if ("USER".equalsIgnoreCase(role)) {
            return new ResponseEntity<List<CartEntityToDto>>(cartService.getAllCartItemsByUserID(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Get the Cart Details", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<?> getAllCarts(@RequestAttribute("role") String role) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<List<CartEntityToDto>>(cartService.getAllCarts(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Get the Cart Details", HttpStatus.NOT_FOUND);
        }
    }
}
