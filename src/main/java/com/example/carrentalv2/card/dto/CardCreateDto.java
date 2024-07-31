package com.example.carrentalv2.card.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateDto {
    private Long cardNumber;
    private String validThru;
    private String owner;
    private String cardName;
}
