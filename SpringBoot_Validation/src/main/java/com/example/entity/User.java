package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String firstName;

    @NonNull
    private String lastName;

    @NotEmpty
    private String address;

    @Email
    private Email email;

    @Min(value = 18, message = "Age must be 18+")
    @Max(value = 50, message = "Age limit less than 50")
    private Integer age;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^[789]\\d{9}$", message = "Phone number must start with 7, 8, or 9 and be exactly 10 digits long")
    private Long phno;

    @Past(message = "Birthdate must be past")
    private LocalDate birthDate;

    @Future(message = "Event date must be Future")
    private LocalDate eventDate;

    @PastOrPresent(message = "Registration must be Present or Future")
    private LocalDate registrationDate;

    @FutureOrPresent(message = "Booking date must be Present Or Future")
    private LocalDate bookingDate;

}
