package com.example.serviceImpl;

import com.example.dto.DtoToOrderEntity;
import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.repo.CartRepo;
import com.example.repo.OrderRepo;
import com.example.repo.UserRepo;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartRepo cartRepo;


    @Override
    public String placeOrder(Long userId, DtoToOrderEntity dtoToCartEntity) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            return "Enter a Valid Token";
        }
//        User user = userOptional.get();

        List<Cart> cartList = cartRepo.findByUser(userOptional.get());
        if (cartList.isEmpty()) {
            return "No Items in the Cart!!";
        }

        Order order = dtoToOrderConverter(dtoToCartEntity);

        double totalPrice = 0;
        List<Book> books = cartList.stream().map(Cart::getBook).collect(Collectors.toList());
        for (Cart cart : cartList) {
            totalPrice += cart.getBook().getBookPrice() * cart.getCartQuantity();
        }

        order.setOrderDate(LocalDate.now());
        order.setOrderPrice(totalPrice);
        order.setOrderQuantity(cartList.size());
        order.setUser(userOptional.get());
        order.setBook(books);

        orderRepo.save(order);
        cartRepo.deleteAll(cartList);
        return "Order Placed Successfully with ID :" + order.getOrderId();
    }

    @Override
    public String cancelOrder(Long userId, Long orderId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            return "Enter a Valid Token";
        }

        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isEmpty()) {
            return "Order NOT Found with ID : " + orderId;
        }
        Order order = optionalOrder.get();
        if (!order.getUser().getUserId().equals(userId)) {
            return "NOT Eligible to CANCEL the Order!!";
        }
        order.setCancelOrder(true);
        orderRepo.save(order);
        return "Order Cancel Successfully with ID : " + orderId;
    }

    @Override
    public Object getAllOrders(Long userId) {
        List<Order> orderList = orderRepo.findAll().stream().filter(cancelOrder -> cancelOrder.getCancelOrder().equals(false)).collect(Collectors.toList());
        if (orderList.isEmpty()){
            return "No Order Is Present!!";
        }
        return orderList;
    }

//    @Override
//    public Object getAllOrdersForUser(Long userId) {
////        Optional<User> userOptional = userRepo.findById(userId);
////        userRepo.findById(userId);
////        if (userOptional.isEmpty()) {
////            return "Enter a Valid Token";
////        }
//        List<Order> userOrders = orderRepo.findByUserId(userId);
//        if (userOrders.isEmpty()){
//            return "No Order Is Present!!";
//        }
//        return userOrders;
//    }


    private Order dtoToOrderConverter(DtoToOrderEntity dtoToOrderEntity) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
//        order.setOrderPrice();
//        order.setOrderQuantity();
        order.setOrderAddress(dtoToOrderEntity.getOrderAddress());
//        order.setUser();
//        order.setBook();
        order.setCancelOrder(false);
        return order;
    }
}
