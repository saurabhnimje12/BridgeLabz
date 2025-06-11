package com.example.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "users")
public class User {
    @Id
    private Long userId;

    @NotBlank
    private String userName;

    @NotBlank
    private String userPwd;

    @NotBlank
    private String role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public @NotBlank String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank String userName) {
        this.userName = userName;
    }

    public @NotBlank String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(@NotBlank String userPwd) {
        this.userPwd = userPwd;
    }

    public @NotBlank String getRole() {
        return role;
    }

    public void setRole(@NotBlank String role) {
        this.role = role;
    }
}
