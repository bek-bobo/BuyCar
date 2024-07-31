package com.example.carrentalv2.card.entity;

import com.example.carrentalv2.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(unique = true)
    private Long cardNumber;

    private String validThru;

    private String owner;

    private String cardName;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
}
