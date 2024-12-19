package com.example.service;

import com.example.dto.CartEntityToDto;
import com.example.dto.DtoToCartEntity;

import java.util.List;

public interface CartService {
    String addToCart(Long userId, Long bookId, DtoToCartEntity dtoToCartEntity);

    String removeFromCart(Long userId, Long cartId);

    String removeByUserID(Long userId);

    String updateQuantityInCart(long userId, Long cartId, Integer quantity);

    List<CartEntityToDto> getAllCartItemsByUserID(Long userId);

    List<CartEntityToDto> getAllCarts();
}
