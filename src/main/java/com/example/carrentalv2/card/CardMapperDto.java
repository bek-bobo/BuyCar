package com.example.carrentalv2.card;

import com.example.carrentalv2.card.dto.CardCreateDto;
import com.example.carrentalv2.card.dto.CardResponseDto;
import com.example.carrentalv2.card.dto.CardUpdateDto;
import com.example.carrentalv2.card.entity.Card;
import com.example.carrentalv2.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapperDto extends GenericMapper<Card, CardCreateDto, CardResponseDto, CardUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Card toEntity(CardCreateDto cardCreateDto) {
        return mapper.map(cardCreateDto, Card.class);
    }

    @Override
    public CardResponseDto toResponseDto(Card card) {
        return mapper.map(card, CardResponseDto.class);
    }

    @Override
    public void updateEntity(CardUpdateDto cardUpdateDto, Card card) {
        mapper.map(cardUpdateDto, card);
    }
}
