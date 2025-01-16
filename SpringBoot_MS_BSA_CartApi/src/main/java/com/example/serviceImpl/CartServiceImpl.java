package com.example.serviceImpl;

import com.example.client.BookClient;
import com.example.client.UserClient;
import com.example.dto.CartEntityToDto;
import com.example.dto.DtoToCartEntity;
import com.example.entity.Cart;
import com.example.exception.CustomiseException;
import com.example.external.Book;
import com.example.external.User;
import com.example.repo.CartRepo;
import com.example.service.CartService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private BookClient bookClient;

    private Book getBookById(Long bookId) {
        Book book = bookClient.getBookById(bookId);
        if (book == null) {
            throw new CustomiseException("Book NOT Available with Id : " + bookId);
        }
        return book;
    }

    private User getUserById(String authorization) {
        User user = userClient.getUser(authorization);
        if (user == null) {
            throw new CustomiseException("User NOT Found in DB with ID : ");
        }
        return user;
    }

    @CircuitBreaker(name = "cartCircuitBreaker", fallbackMethod = "addToCartFallback")
    @Override
    public String addToCart(String authorization, Long bookId, DtoToCartEntity dtoToCartEntity) {
        Book book = getBookById(bookId);
        User user = getUserById(authorization);
        Cart cart = dtoToCartConverter(dtoToCartEntity);
        cart.setUserId(user.getUserId());
        cart.setBookId(book.getBookId());
        cart.setTotalPrice(dtoToCartEntity.getCartQuantity() * book.getBookPrice());
        cartRepo.save(cart);
        return "Book Added to Cart Successfully!!";
    }

    public String addToCartFallback(Exception exception) {
        return "Please Try After Some Time!!";
    }

    @Override
    public String removeFromCart(String authorization, Long cartId) {
        User user = getUserById(authorization);
        Optional<Cart> optionalCart = cartRepo.findById(cartId);
        if (optionalCart.isPresent() && user.getUserId().equals(optionalCart.get().getUserId())) {
            cartRepo.delete(optionalCart.get());
            return "Remove From Cart Successfully";
        } else {
            return "Enter a Valid Details : Token No | CartId";
        }
    }

    @Override
    public String removeByUserID(String authorization) {
        User user = getUserById(authorization);
        List<Cart> cartList = cartRepo.findByUserId(user.getUserId());
        if (!cartList.isEmpty()) {
            cartRepo.deleteAll(cartList);
            return "All Cart Deleted for User";
        } else {
            return "Enter a Valid Details | Token No";
        }
    }

    @Override
    public String updateQuantityInCart(String authorization, Long cartId, Integer quantity) {
        User user = getUserById(authorization);
        Optional<Cart> optionalCart = cartRepo.findById(cartId);
        if (optionalCart.isPresent() && optionalCart.get().getUserId().equals(user.getUserId())) {
            Cart cart = optionalCart.get();
            cart.setCartQuantity(quantity);
            cartRepo.save(cart);
            return "Cart Updated Successfully with Id : " + cartId;
        } else {
            return "Enter a Valid Cart Id for Update ";
        }
    }

    @Override
    public List<CartEntityToDto> getAllCartItemsByUserID(String authorization) {
        User user = getUserById(authorization);
        List<Cart> cartList = cartRepo.findByUserId(user.getUserId());
        if (!cartList.isEmpty()) {
            return cartList.stream().map(this::cartToDtoConverter).collect(Collectors.toList());
        } else {
            throw new CustomiseException("No Cart is Available with USER");
        }
    }

    @Override
    public List<CartEntityToDto> getAllCarts() {
        List<Cart> cartList = cartRepo.findAll();
        if (!cartList.isEmpty()) {
            return cartList.stream().map(this::cartToDtoConverter).collect(Collectors.toList());
        } else {
            throw new CustomiseException("No Cart is Available!!");
        }
    }

    private Cart dtoToCartConverter(DtoToCartEntity dtoToCartEntity) {
        Cart cart = new Cart();
        cart.setCartQuantity(dtoToCartEntity.getCartQuantity());
        return cart;
    }

    private CartEntityToDto cartToDtoConverter(Cart cart) {
        CartEntityToDto cartEntityToDto = new CartEntityToDto();
        cartEntityToDto.setCartId(cart.getCartId());
        cartEntityToDto.setUserId(cart.getUserId());
        cartEntityToDto.setBookId(cart.getBookId());
        cartEntityToDto.setCartQuantity(cart.getCartQuantity());
        cartEntityToDto.setTotalPrice(cart.getTotalPrice());
        return cartEntityToDto;
    }
}