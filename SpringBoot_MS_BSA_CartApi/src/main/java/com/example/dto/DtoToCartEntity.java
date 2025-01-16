package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DtoToCartEntity {
    @NotNull(message = "Cart quantity cannot be null")
    @Min(value = 1, message = "Cart quantity must be at least 1")
    private Integer cartQuantity;

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
