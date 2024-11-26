package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToDto {

    private Integer empId;
    private String firstName;
    private String lastName;
    private String gender;
    private String department;
    private LocalDate dateOfJoin;
    private String notes;
    private Double salary;
    private byte[] profilePic;
}
