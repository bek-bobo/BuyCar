package com.example.carrentalv2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String gender;
    private String address;
    private String accountNumber;
    private BigDecimal accountBalance;
    private String phoneNumber;
    private String email;
    private String password;
    private String alternativePhoneNumber;
}
