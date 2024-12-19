package com.example.service;

import com.example.dto.DtoToOrderEntity;

public interface OrderService {
    String placeOrder(Long userId,DtoToOrderEntity dtoToCartEntity);

    String cancelOrder(Long userId, Long orderId);

    Object getAllOrders(Long userId);

//    Object getAllOrdersForUser(Long userId);
}
