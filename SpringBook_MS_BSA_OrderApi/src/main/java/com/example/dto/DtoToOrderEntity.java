package com.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DtoToOrderEntity {
    @NotNull(message = "Order address cannot be null.")
    @NotEmpty(message = "Order address cannot be empty.")
    @Size(min = 5, max = 255, message = "Order address must be between 5 and 255 characters.")
    private String orderAddress;

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }
}
