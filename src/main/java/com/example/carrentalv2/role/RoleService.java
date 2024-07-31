package com.example.carrentalv2.role;

import com.example.carrentalv2.common.exception.ExceptionAllProject;
import com.example.carrentalv2.common.service.GenericService;
import com.example.carrentalv2.permission.PermissionRepository;
import com.example.carrentalv2.permission.entity.Permission;
import com.example.carrentalv2.role.dto.RoleCreateDto;
import com.example.carrentalv2.role.dto.RoleResponseDto;
import com.example.carrentalv2.role.dto.RoleUpdateDto;
import com.example.carrentalv2.role.entity.Role;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class RoleService extends GenericService<Role, UUID, RoleCreateDto, RoleResponseDto, RoleUpdateDto> {
    private final RoleRepository repository;
    private final RoleMapperDto mapper;
    private final Class<Role> entityClass = Role.class;
    private final PermissionRepository permissionRepository;

    @Override
    protected RoleResponseDto internalCreate(RoleCreateDto roleCreateDto) {
        Role entity = mapper.toEntity(roleCreateDto);

        Set<String> dtoPermissionsNames = roleCreateDto.getPermissions();
        Set<Permission> permissions = permissionRepository.findAllByNameIn(roleCreateDto.getPermissions());
        if (dtoPermissionsNames.size() != permissions.size()) {
            Set<String> collected = permissions
                    .stream()
                    .map(Permission::getName)
                    .collect(Collectors.toSet());
            dtoPermissionsNames.removeAll(collected);

            throw new EntityNotFoundException("Permission with these names not found. Permission:  %s".formatted(dtoPermissionsNames));
        }

        entity.setPermissions(permissions);
        entity.setId(UUID.randomUUID());
        Role saved = repository.save(entity);
        return mapper.toResponseDto(saved);

    }

    public RoleResponseDto getByName(String name) {
        Role role = repository
                .findByName(name).orElseThrow(
                        () -> new EntityNotFoundException("Role with name: %s not found".formatted(name))
                );
        return mapper.toResponseDto(role);
    }

    @Override
    protected RoleResponseDto internalUpdate(UUID uuid, RoleUpdateDto roleUpdateDto) {
        Role role = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException(ExceptionAllProject.ROLE_NOT_FOUND.formatted(uuid))
        );
        mapper.updateEntity(roleUpdateDto, role);
        Role saved = repository.save(role);
        return mapper.toResponseDto(saved);
    }
}
