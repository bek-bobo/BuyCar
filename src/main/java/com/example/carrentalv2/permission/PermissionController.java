package com.example.carrentalv2.permission;

import com.example.carrentalv2.permission.dto.PermissionCreateDto;
import com.example.carrentalv2.permission.dto.PermissionResponseDto;
import com.example.carrentalv2.permission.dto.PermissionUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("permission")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponseDto> createPermission(@RequestBody @Valid PermissionCreateDto permissionCreateDto) {
        PermissionResponseDto permissionResponseDto = permissionService.create(permissionCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<PermissionResponseDto>> getAllPermissions(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<PermissionResponseDto> permissionResponseDTOS = permissionService.get(predicate, pageable);
        return ResponseEntity.ok().body(permissionResponseDTOS);
    }

    @GetMapping("/{name}")
    public ResponseEntity<PermissionResponseDto> getPermissionId(@PathVariable String name) {
        PermissionResponseDto permissionResponseDto = permissionService.getByName(name);
        return ResponseEntity.ok().body(permissionResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDto> updatePermission(@PathVariable UUID id, @RequestBody PermissionUpdateDto permissionUpdateDto) {
        PermissionResponseDto updated = permissionService.update(id, permissionUpdateDto);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePermission(@PathVariable UUID id) {
        permissionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
