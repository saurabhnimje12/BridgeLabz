package com.example.serviceImpl;

import com.example.dto.CartEntityToDto;
import com.example.dto.DtoToCartEntity;
import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.exception.CustomiseException;
import com.example.repo.BookRepo;
import com.example.repo.CartRepo;
import com.example.repo.UserRepo;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CartRepo cartRepo;


    @Override
    public String addToCart(Long userId, Long bookId, DtoToCartEntity dtoToCartEntity) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new CustomiseException("Book NOT Found with ID: " + bookId));
        if (book.getBookQuantity() <= 0) {
            throw new CustomiseException("Book NOT Available : " + book.getBookName());
        }
        User user = userRepo.findById(userId).orElseThrow(() -> new CustomiseException("User NOT Found with ID : " + userId));
        if (dtoToCartEntity.getCartQuantity() > book.getBookQuantity()) {
            throw new CustomiseException("Enter Valid Quantity!!    |   Available: " + book.getBookQuantity());
        }
        Cart cart = dtoToCartConverter(dtoToCartEntity);
        cart.setUser(user);
        cart.setBook(book);
        cart.setTotalPrice(dtoToCartEntity.getCartQuantity() * book.getBookPrice());
        cartRepo.save(cart);
        book.setBookQuantity(book.getBookQuantity() - dtoToCartEntity.getCartQuantity());
        bookRepo.save(book);
        return "Book Added to Cart Successfully!!";
    }

    @Override
    public String removeFromCart(Long userId, Long cartId) {
        Optional<Cart> optionalCart = cartRepo.findById(cartId);
        if (optionalCart.isPresent() && userId.equals(optionalCart.get().getUser().getUserId())) {
//            Cart cart = optionalCart.get();
//            cart.setUser(null);
//            cart.setBook(null);
//            Book book = cart.getBook();
//            book.setBookQuantity(book.getBookQuantity() + cart.getCartQuantity());
//            bookRepo.save(book);
            cartRepo.deleteById(optionalCart.get().getCartId());
            return "Remove From Cart Successfully";
        } else {
            return "Enter a Valid Details : Token No | CartId";
        }
    }

    @Override
    public String removeByUserID(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        List<Cart> cartList = cartRepo.findByUser(userOptional.get());
        if (!cartList.isEmpty()) {
            for (Cart cart : cartList) {
                Book book = cart.getBook();
                book.setBookQuantity(book.getBookQuantity() + cart.getCartQuantity());
                bookRepo.save(book);
            }
            cartRepo.deleteAll(cartList);
            return "All Cart Deleted for User ID: " + userId;
        } else {
            return "Enter a Valid User ID : " + userId;
        }
    }

    @Override
    public String updateQuantityInCart(long userId, Long cartId, Integer quantity) {
        Optional<User> optionalUser = userRepo.findById(userId);
        Optional<Cart> optionalCart = cartRepo.findById(cartId);
        if (!Objects.equals(optionalUser.get().getUserId(), optionalCart.get().getUser().getUserId())) {
            throw new CustomiseException("Enter a Valid Cart Id for Update : " + userId);
        }
        Cart cart = optionalCart.get();
        Book book = cart.getBook();
        if (quantity <= book.getBookQuantity()) {
            throw new CustomiseException("Enter a Valid Quantity To Update Cart!! Available : " + book.getBookQuantity());
        }
        cart.setCartQuantity(cart.getCartQuantity() + quantity);
        cartRepo.save(cart);
        book.setBookQuantity(book.getBookQuantity() - quantity);
        bookRepo.save(book);
        return "Cart Updated Successfully with Id : " + cartId;
    }

    @Override
    public List<CartEntityToDto> getAllCartItemsByUserID(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        List<Cart> cartList = cartRepo.findByUser(userOptional.get());
        if (!cartList.isEmpty()) {
            return cartList.stream().map(this::cartToDtoConverter).collect(Collectors.toList());
        } else {
            throw new CustomiseException("No Cart is Available with USER ID : " + userId);
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
        cartEntityToDto.setUser(cart.getUser());
        cartEntityToDto.setBook(cart.getBook());
        cartEntityToDto.setCartQuantity(cart.getCartQuantity());
        cartEntityToDto.setTotalPrice(cart.getTotalPrice());
        return cartEntityToDto;
    }
}
