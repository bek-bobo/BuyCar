package com.example.carrentalv2.common.service;

import com.example.carrentalv2.common.mapper.GenericMapper;
import com.example.carrentalv2.common.repository.GenericRepository;
import com.example.carrentalv2.common.rsql.SpecificationBuilder;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericService<ENTITY, ID, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO> {
    protected abstract GenericRepository<ENTITY, ID> getRepository();
    protected abstract Class<ENTITY> getEntityClass();
    protected abstract GenericMapper<ENTITY, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO> getMapper();
    protected abstract RESPONSE_DTO internalCreate(CREATE_DTO createDto);
    protected abstract RESPONSE_DTO internalUpdate(ID id, UPDATE_DTO updateDto);

    public RESPONSE_DTO create(CREATE_DTO createDto){
        return internalCreate(createDto);
    }

    @Transactional
    public Page<RESPONSE_DTO> get(String predicate, Pageable pageable){
        Specification<ENTITY> specification = SpecificationBuilder.build(predicate);
        Page<ENTITY> page;
        if (specification == null){
            page = getRepository().findAll(pageable);
        }else {
            page = getRepository().findAll(specification, pageable);
        }

        return page.map(entity -> getMapper().toResponseDto(entity));
    }

    @Transactional
    public RESPONSE_DTO get(ID id){
        ENTITY entity = getRepository().findById(id).orElseThrow(
                () -> new EntityNotFoundException("%s with id: %s not found".formatted(getEntityClass()
                        .getSimpleName(), id))
        );
        return getMapper().toResponseDto(entity);
    }

    public RESPONSE_DTO update(ID id, UPDATE_DTO updateDto){
        return internalUpdate(id, updateDto);
    }

    @Transactional
    public void delete(ID id){
        getRepository().findById(id).orElseThrow(
                () -> new EntityNotFoundException("%s with id: %s not found".formatted(getEntityClass().getSimpleName(), id))
        );
        getRepository().deleteById(id);
    }
}
