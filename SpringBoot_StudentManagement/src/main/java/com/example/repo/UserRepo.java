package com.example.repo;

import com.example.entity.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {
    Optional<User> findByUserName(@NotBlank String userName);

    Optional<User> findByUserNameAndUserPwd(String userName, String userPwd);
}
