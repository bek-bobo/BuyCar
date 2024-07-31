package com.example.carrentalv2.card;

import com.example.carrentalv2.card.dto.CardCreateDto;
import com.example.carrentalv2.card.dto.CardResponseDto;
import com.example.carrentalv2.card.dto.CardUpdateDto;
import com.example.carrentalv2.card.entity.Card;
import com.example.carrentalv2.common.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class CardService extends GenericService<Card, Long, CardCreateDto, CardResponseDto, CardUpdateDto> {

    private final CardRepository repository;
    private final CardMapperDto mapper;
    private final Class<Card> entityClass = Card.class;

    @Override
    protected CardResponseDto internalCreate(CardCreateDto cardCreateDto) {
        Card entity = mapper.toEntity(cardCreateDto);
        Card saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected CardResponseDto internalUpdate(Long aLong, CardUpdateDto cardUpdateDto) {
        Card card = repository.findById(aLong).orElseThrow(
                () -> new EntityNotFoundException("Card with id %s not found".formatted(aLong))
        );
        card.setCardName(cardUpdateDto.getCardName());
        mapper.updateEntity(cardUpdateDto, card);
        Card saved = repository.save(card);
        return mapper.toResponseDto(saved);
    }
}
