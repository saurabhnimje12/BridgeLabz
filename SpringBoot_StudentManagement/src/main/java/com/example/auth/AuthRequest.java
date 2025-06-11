package com.example.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String userPwd;

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
}
