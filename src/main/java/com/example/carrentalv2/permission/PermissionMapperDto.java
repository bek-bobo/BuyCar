package com.example.carrentalv2.permission;

import com.example.carrentalv2.common.mapper.GenericMapper;
import com.example.carrentalv2.permission.dto.PermissionCreateDto;
import com.example.carrentalv2.permission.dto.PermissionResponseDto;
import com.example.carrentalv2.permission.dto.PermissionUpdateDto;
import com.example.carrentalv2.permission.entity.Permission;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionMapperDto extends GenericMapper<Permission, PermissionCreateDto, PermissionResponseDto, PermissionUpdateDto> {
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public Permission toEntity(PermissionCreateDto permissionCreateDto) {
        return mapper.map(permissionCreateDto, Permission.class);
    }

    @Override
    public PermissionResponseDto toResponseDto(Permission permission) {
        return mapper.map(permission, PermissionResponseDto.class);
    }

    @Override
    public void updateEntity(PermissionUpdateDto permissionUpdateDto, Permission permission) {
        mapper.map(permissionUpdateDto, permission);
    }
}
