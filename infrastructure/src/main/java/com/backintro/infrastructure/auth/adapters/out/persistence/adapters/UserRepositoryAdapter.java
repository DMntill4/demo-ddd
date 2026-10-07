package com.backintro.infrastructure.auth.adapters.out.persistence.adapters;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.model.valueobject.UserId;
import com.backintro.domain.auth.port.repository.UserRepository;
import com.backintro.infrastructure.auth.adapters.out.persistence.entities.RoleJpaEntity;
import com.backintro.infrastructure.auth.adapters.out.persistence.entities.UserJpaEntity;
import com.backintro.infrastructure.auth.adapters.out.persistence.mappers.UserPersistenceMapper;
import com.backintro.infrastructure.auth.adapters.out.persistence.repositories.RoleJpaRepository;
import com.backintro.infrastructure.auth.adapters.out.persistence.repositories.UserJpaRepository;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userRepository;
    private final RoleJpaRepository roleRepository;
    private final UserPersistenceMapper mapper;

    public UserRepositoryAdapter(
            UserJpaRepository userRepository,
            RoleJpaRepository roleRepository,
            UserPersistenceMapper mapper
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        Set<RoleJpaEntity> roleEntities = new HashSet<>();
        for (Role r : user.getRoles()) {
            roleRepository.findByName(r.getName()).ifPresent(roleEntities::add);
        }

        UserJpaEntity entity = mapper.toJpa(user, roleEntities);
        UserJpaEntity saved = userRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return userRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userRepository.findByEmail(email.value()).map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userRepository.existsByEmail(email.value());
    }
}
