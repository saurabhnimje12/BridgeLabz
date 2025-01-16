package com.example.consumer;

import com.example.configuration.MessagingConfig;
import com.example.entity.OrderStatus;
import com.example.utils.EmailUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Autowired
    private EmailUtils emailUtils;

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from queue : " + orderStatus);
        String msg = emailUtils.sendEmail(orderStatus.getOrder().getEmail(), "Email From Restaurant", orderStatus.getMessage());
        System.out.println("Mail Message : " + msg);
    }
}
