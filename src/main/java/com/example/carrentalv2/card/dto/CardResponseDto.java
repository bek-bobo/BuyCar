package com.example.carrentalv2.card.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {
    private Long cardNumber;
    private String validThru;
    private String owner;
    private String cardName;

}
