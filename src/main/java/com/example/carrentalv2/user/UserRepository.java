package com.example.carrentalv2.user;

import com.example.carrentalv2.common.repository.GenericRepository;
import com.example.carrentalv2.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends GenericRepository<User, UUID> {

    Optional<User> findByPhoneNumber(String phoneNumber);
    Boolean existsAllByEmail(String email);
}
