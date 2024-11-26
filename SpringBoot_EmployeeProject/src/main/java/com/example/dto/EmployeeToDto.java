package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToDto {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phno;
    private Integer age;
    private String gender;
    private String department;
    private LocalDate dateOfJoin;
    private String notes;
    private Double salary;
    private String profilePic;
    private List<AddressToDto> address;
}
