package com.example.service;

import com.example.dto.DtoToOrderEntity;

public interface OrderService {
    String placeOrder(String authorization,DtoToOrderEntity dtoToCartEntity);

    String cancelOrder(String authorization, Long orderId);

    Object getAllOrders();

    Object getAllOrdersForUser(String authorization);
}
