package com.example.carrentalv2.role;

import com.example.carrentalv2.role.dto.RoleCreateDto;
import com.example.carrentalv2.role.dto.RoleResponseDto;
import com.example.carrentalv2.role.dto.RoleUpdateDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody @Valid RoleCreateDto roleCreateDto){
        RoleResponseDto roleResponseDto = roleService.create(roleCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<RoleResponseDto>> getAllRoles(@RequestParam(required = false) String predicate, Pageable pageable){
        Page<RoleResponseDto> roleResponseDTOS = roleService.get(predicate, pageable);
        return ResponseEntity.ok().body(roleResponseDTOS);
    }

    @GetMapping("/{name}")
    public ResponseEntity<RoleResponseDto> getRoleId(@PathVariable String name){
        RoleResponseDto roleResponseDto = roleService.getByName(name);
        return ResponseEntity.ok().body(roleResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(@PathVariable UUID id, @RequestBody RoleUpdateDto roleUpdateDto){
        RoleResponseDto updated = roleService.update(id, roleUpdateDto);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable UUID id){
        roleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
