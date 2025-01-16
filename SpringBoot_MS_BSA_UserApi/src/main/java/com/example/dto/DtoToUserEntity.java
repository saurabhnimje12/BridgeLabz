package com.example.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DtoToUserEntity {
    @NotBlank
    @Pattern(regexp =  "^[A-Z][a-z]+$", message = "First name start with capital letter only (e.g : John)")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name start with capital letter only (e.g : Roy)")
    private String lastName;
    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter a valid email Id (e.g : john@gmail.com)")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$", message = "Password must be at least 8 characters long and include an uppercase letter, a lowercase letter, a digit, and a special character")
    private String password;
    @Pattern(regexp = "^(ADMIN|USER|GUEST)$", message = "Role must be one of the following: ADMIN, USER, GUEST")
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
