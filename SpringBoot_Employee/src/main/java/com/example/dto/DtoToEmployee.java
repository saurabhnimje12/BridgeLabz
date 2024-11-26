package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoToEmployee {
    private String firstName;
    private String lastName;
    private String gender;
    private String department;
    private String notes;
    private Double salary;
    private byte[] profilePic;
}
