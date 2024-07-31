package com.example.carrentalv2.card;

import com.example.carrentalv2.card.dto.CardCreateDto;
import com.example.carrentalv2.card.dto.CardResponseDto;
import com.example.carrentalv2.card.dto.CardUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponseDto> createCard(@RequestBody @Valid CardCreateDto cardCreateDto){
        CardResponseDto cardResponseDto = cardService.create(cardCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<CardResponseDto>> getAllCards(@RequestParam(required = false) String predicate, Pageable pageable){
        Page<CardResponseDto> cardResponseDTOS = cardService.get(predicate, pageable);
        return ResponseEntity.ok().body(cardResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> getCard(@PathVariable Long id){
        CardResponseDto cardResponseDto = cardService.get(id);
        return ResponseEntity.ok().body(cardResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable Long id, @RequestBody CardUpdateDto cardUpdateDto){
        CardResponseDto updated = cardService.update(id, cardUpdateDto);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id){
        cardService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
