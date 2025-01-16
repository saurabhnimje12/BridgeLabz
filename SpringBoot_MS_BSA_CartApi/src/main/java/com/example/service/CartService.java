package com.example.service;

import com.example.dto.CartEntityToDto;
import com.example.dto.DtoToCartEntity;

import java.util.List;

public interface CartService {
    String addToCart(String authorization, Long bookId, DtoToCartEntity dtoToCartEntity);

    String removeFromCart(String authorization, Long cartId);

    String removeByUserID(String authorization);

    String updateQuantityInCart(String authorization, Long cartId, Integer quantity);

    List<CartEntityToDto> getAllCartItemsByUserID(String authorization);

    List<CartEntityToDto> getAllCarts();
}
