package com.example.dto;

import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressToDto {
    private String addressType;
    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    private String pinCode;
}
