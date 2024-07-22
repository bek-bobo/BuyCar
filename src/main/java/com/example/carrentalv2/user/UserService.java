package com.example.carrentalv2.user;

import com.example.carrentalv2.common.exception.ExceptionAllProject;
import com.example.carrentalv2.common.service.GenericService;
import com.example.carrentalv2.user.dto.*;
import com.example.carrentalv2.user.entity.User;
import com.example.carrentalv2.user.utils.AccountUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class UserService extends GenericService<User, UUID, UserCreateDto, UserResponseDto, UserUpdateDto> {

    private final UserRepository repository;
    private final UserMapperDto mapper;
    private Class<User> entityClass = User.class;

    @Override
    protected UserResponseDto internalCreate(UserCreateDto userCreateDto) {
        User entity = mapper.toEntity(userCreateDto);
        entity.setId(UUID.randomUUID());
        entity.setAccountNumber(AccountUtils.generateAccountNumber());
        entity.setAccountBalance(BigDecimal.ZERO);
        entity.setStatus("ACTIVE");
        User saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected UserResponseDto internalUpdate(UUID uuid, UserUpdateDto userUpdateDto) {
        return null;
    }
}
