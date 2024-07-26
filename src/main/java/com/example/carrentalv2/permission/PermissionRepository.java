package com.example.carrentalv2.permission;

import com.example.carrentalv2.common.repository.GenericRepository;
import com.example.carrentalv2.permission.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PermissionRepository extends GenericRepository<Permission, UUID> {
    Set<Permission> findAllByNameIn(Set<String> permission);

    Optional<Permission> findByName(String name);

}
