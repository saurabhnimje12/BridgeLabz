package com.example.repo;

import com.example.entity.Cart;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
//
//    List<Cart> findByUserId(Long userId);
//
//    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId")
//    List<Cart> findByUser(@Param("userId") Long userId);

}
