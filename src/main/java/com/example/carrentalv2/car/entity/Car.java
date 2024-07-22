package com.example.carrentalv2.car.entity;

import com.example.carrentalv2.car.enu.Condition;
import com.example.carrentalv2.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Condition condition;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String madeIn;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

}
