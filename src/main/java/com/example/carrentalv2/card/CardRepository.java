package com.example.carrentalv2.card;

import com.example.carrentalv2.card.entity.Card;
import com.example.carrentalv2.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends GenericRepository<Card, Long> {
}
