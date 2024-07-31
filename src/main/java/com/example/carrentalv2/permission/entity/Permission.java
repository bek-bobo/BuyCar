package com.example.carrentalv2.permission.entity;

import com.example.carrentalv2.role.entity.Role;
import com.example.carrentalv2.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;

    @ManyToMany(mappedBy = "permissions")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;
}
