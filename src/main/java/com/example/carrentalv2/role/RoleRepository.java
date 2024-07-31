package com.example.carrentalv2.role;

import com.example.carrentalv2.common.repository.GenericRepository;
import com.example.carrentalv2.role.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends GenericRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
