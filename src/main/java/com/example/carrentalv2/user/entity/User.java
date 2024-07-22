package com.example.carrentalv2.user.entity;

import com.example.carrentalv2.car.entity.Car;
import com.example.carrentalv2.card.entity.Card;
import com.example.carrentalv2.permission.entity.Permission;
import com.example.carrentalv2.role.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`users`")
public class User {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String accountNumber;


    private BigDecimal accountBalance;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String alternativePhoneNumber;

    @Column(nullable = false)
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permisisons",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;
}
