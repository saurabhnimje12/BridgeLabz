package com.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtility {
    private static final String SECRET = "SecretKey";
    private static final long EXPIRATION_TIME = 600_000; // 15 minutes

    public String createToken(Long userId, String role) {
        return JWT.create().withClaim("userId", userId).withClaim("role", role).withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(Algorithm.HMAC256(SECRET));
    }

    public Long decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim("userId").asLong();
    }

    public String getRoleFromToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim("role").asString();
    }

    public Long getEmpIdFromToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim("userId").asLong();
    }

    // Method to extract the expiration date from the token
    public Date getExpirationFromToken(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return decodedJWT.getExpiresAt();
    }
}
