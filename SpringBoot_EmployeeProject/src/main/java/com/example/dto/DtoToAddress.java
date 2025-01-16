package com.example.dto;

import com.example.entity.Employee;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DtoToAddress {
    @NotBlank(message = "Address type cannot be blank")
    @Pattern(regexp = "^(Current|Permanent)$", message = "Enter Valid Option (e.g : Current | Permanent)")
    private String addressType;
    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    @NotBlank
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Enter a Valid Pin-Code")
    private String pinCode;
}
