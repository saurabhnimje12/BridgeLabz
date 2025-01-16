package com.example.serviceImpl;

import com.example.client.CartClient;
import com.example.client.UserClient;
import com.example.dto.DtoToOrderEntity;
import com.example.entity.Order;
import com.example.exception.CustomiseException;
import com.example.external.Cart;
import com.example.external.User;
import com.example.repo.OrderRepo;
import com.example.service.OrderService;
import com.example.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserClient userClient;
    @Autowired
    private CartClient cartClient;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private EmailUtils emailUtils;

    private User getUserById(String authorization) {
        User user = userClient.getUser(authorization);
        if (user == null) {
            throw new CustomiseException("User NOT Found in DB with ID : ");
        }
        return user;
    }

    private List<Cart> getCartsList(String role, String authorization) {
        List<Cart> cartList = cartClient.cartsList(role, authorization);
        if (cartList.isEmpty()) {
            throw new CustomiseException("Book NOT Available ");
        }
        return cartList;
    }

    @Override
    public String placeOrder(String authorization, DtoToOrderEntity dtoToCartEntity) {
        User user = getUserById(authorization);
        List<Cart> cartList = getCartsList(authorization, authorization);
        Order order = dtoToOrderConverter(dtoToCartEntity);
        double totalPrice = 0;
        Integer totalQuantity = 0;
        ArrayList<Long> bookIds = new ArrayList<>();
        for (Cart cart : cartList) {
            totalPrice += cart.getTotalPrice();
            totalQuantity += cart.getCartQuantity();
            bookIds.add(cart.getBookId());
        }
        order.setOrderDate(LocalDate.now());
        order.setOrderPrice(totalPrice);
        order.setOrderQuantity(totalQuantity);
        order.setUserId(user.getUserId());
        order.setBookId(bookIds);
        order.setCancelOrder(false);
        orderRepo.save(order);
        emailUtils.sendEmail(user.getEmail(), "Book Store Application", "Hello, "+user.getFirstName()+" Welcome To Book Store Application, Your Order was Placed Successfully!!! /n "+order.toString() );
        return "Order Placed Successfully with ID :" + order.getOrderId();
    }

    @Override
    public String cancelOrder(String authorization, Long orderId) {
        User user = getUserById(authorization);
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new CustomiseException("Order NOT Found with Id : " + orderId));
        if (!order.getUserId().equals(user.getUserId())) {
            return "NOT Eligible to CANCEL the Order!!";
        }
        order.setCancelOrder(true);
        orderRepo.save(order);
        emailUtils.sendEmail(user.getEmail(), "Book Store Application", "Hello, "+user.getFirstName()+" Welcome To Book Store Application, Your Order was Cancelled Successfully!!! /n "+order.toString() );
        return "Order Cancel Successfully with ID : " + orderId;
    }

    @Override
    public Object getAllOrders() {
        List<Order> orderList = orderRepo.findAll().stream().filter(cancelOrder -> cancelOrder.getCancelOrder().equals(false)).collect(Collectors.toList());
        if (orderList.isEmpty()) {
            return "No Order Is Present!!";
        }
        return orderList;
    }

    @Override
    public Object getAllOrdersForUser(String authorization) {
        User user = getUserById(authorization);
        List<Order> orderList = orderRepo.findByUserId(user.getUserId());
        if (orderList.isEmpty()) {
            return "No Order Is Present!!";
        }
        return orderList;
    }

    private Order dtoToOrderConverter(DtoToOrderEntity dtoToOrderEntity) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setOrderAddress(dtoToOrderEntity.getOrderAddress());
        return order;
    }
}
