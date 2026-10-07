package com.backintro.infrastructure.auth.adapters.out.persistence.adapters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.port.repository.RoleRepository;
import com.backintro.infrastructure.auth.adapters.out.persistence.entities.RoleJpaEntity;
import com.backintro.infrastructure.auth.adapters.out.persistence.mappers.UserPersistenceMapper;
import com.backintro.infrastructure.auth.adapters.out.persistence.repositories.RoleJpaRepository;

@Component
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository roleRepository;
    private final UserPersistenceMapper mapper;

    public RoleRepositoryAdapter(RoleJpaRepository roleRepository, UserPersistenceMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name).map(mapper::toDomainRole);
    }

    @Override
    public Role save(Role role) {
        RoleJpaEntity entity = mapper.toJpaRole(role);
        RoleJpaEntity saved = roleRepository.save(entity);
        return mapper.toDomainRole(saved);
    }
}
