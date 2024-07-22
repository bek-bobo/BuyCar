package com.example.carrentalv2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private UUID id;
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
    private String alternativePhoneNumber;
    private String status;
}
