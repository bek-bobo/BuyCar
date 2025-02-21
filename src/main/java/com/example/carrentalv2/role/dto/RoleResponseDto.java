package com.example.carrentalv2.role.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDto {
    private String name;
    private Set<String> permissions;


}
