package com.example.carrentalv2.permission;

import com.example.carrentalv2.common.exception.ExceptionAllProject;
import com.example.carrentalv2.common.service.GenericService;
import com.example.carrentalv2.permission.dto.PermissionCreateDto;
import com.example.carrentalv2.permission.dto.PermissionResponseDto;
import com.example.carrentalv2.permission.dto.PermissionUpdateDto;
import com.example.carrentalv2.permission.entity.Permission;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class PermissionService extends GenericService<Permission, UUID, PermissionCreateDto, PermissionResponseDto, PermissionUpdateDto> {

    private final PermissionRepository repository;
    private final PermissionMapperDto mapper;
    private final Class<Permission> entityClass = Permission.class;


    @Override
    protected PermissionResponseDto internalCreate(PermissionCreateDto permissionCreateDto) {
        Permission entity = mapper.toEntity(permissionCreateDto);
        entity.setId(UUID.randomUUID());
        Permission saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    public PermissionResponseDto getByName(String name) {
        Permission permission = repository
                .findByName(name)
                .orElseThrow(
                        () -> new EntityNotFoundException("Role with name: %s not found".formatted(name))
                );
        return mapper.toResponseDto(permission);
    }

    @Override
    protected PermissionResponseDto internalUpdate(UUID uuid, PermissionUpdateDto permissionUpdateDto) {
        Permission entity = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException(ExceptionAllProject.PERMISSION_NOT_FOUND.formatted(uuid))
        );
        mapper.updateEntity(permissionUpdateDto, entity);
        Permission saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }
}
