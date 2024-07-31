package com.example.carrentalv2.user;

import com.example.carrentalv2.user.dto.UserCreateDto;
import com.example.carrentalv2.user.dto.UserResponseDto;
import com.example.carrentalv2.user.dto.UserUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserCreateDto userCreateDto){
        UserResponseDto userResponseDto = userService.create(userCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(@RequestParam(required = false) String predicate, Pageable pageable){
        Page<UserResponseDto> userResponseDtoPage = userService.get(predicate, pageable);
        return ResponseEntity.ok(userResponseDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id){
        UserResponseDto userResponseDto = userService.get(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, UserUpdateDto userUpdateDto){
        UserResponseDto updated = userService.update(id, userUpdateDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
