package com.example.carrentalv2.role;

import com.example.carrentalv2.common.mapper.GenericMapper;
import com.example.carrentalv2.role.dto.RoleCreateDto;
import com.example.carrentalv2.role.dto.RoleResponseDto;
import com.example.carrentalv2.role.dto.RoleUpdateDto;
import com.example.carrentalv2.role.entity.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapperDto extends GenericMapper<Role, RoleCreateDto, RoleResponseDto, RoleUpdateDto> {
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public Role toEntity(RoleCreateDto roleCreateDto) {
        return mapper.map(roleCreateDto, Role.class);
    }

    @Override
    public RoleResponseDto toResponseDto(Role role) {
        return mapper.map(role, RoleResponseDto.class);
    }

    @Override
    public void updateEntity(RoleUpdateDto roleUpdateDto, Role role) {
        mapper.map(roleUpdateDto, role);
    }
}
