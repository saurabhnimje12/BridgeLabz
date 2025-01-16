package com.example.publisher;

import com.example.configuration.MessagingConfig;
import com.example.entity.Order;
import com.example.entity.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/orderPublisher")
public class OrderPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("bookOrder/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Placed Successfully In : " + restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success!!";
    }
}
