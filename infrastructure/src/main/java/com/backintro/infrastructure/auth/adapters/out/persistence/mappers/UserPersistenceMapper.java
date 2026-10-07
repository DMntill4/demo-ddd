package com.backintro.infrastructure.auth.adapters.out.persistence.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.model.valueobject.PasswordHash;
import com.backintro.domain.auth.model.valueobject.UserId;
import com.backintro.infrastructure.auth.adapters.out.persistence.entities.RoleJpaEntity;
import com.backintro.infrastructure.auth.adapters.out.persistence.entities.UserJpaEntity;

@Component
public class UserPersistenceMapper {

    public Role toDomainRole(RoleJpaEntity entity) {
        if (entity == null) return null;
        return Role.of(entity.getId(), entity.getName(), entity.getDescription());
    }

    public RoleJpaEntity toJpaRole(Role domain) {
        if (domain == null) return null;
        return new RoleJpaEntity(domain.getId(), domain.getName(), domain.getDescription(), null);
    }

    public User toDomain(UserJpaEntity entity) {
        if (entity == null) return null;

        Set<Role> roles = entity.getRoles().stream()
                .map(this::toDomainRole)
                .collect(Collectors.toSet());

        return User.restore(
                UserId.of(entity.getId()),
                Email.of(entity.getEmail()),
                PasswordHash.of(entity.getPasswordHash()),
                roles,
                entity.isActive(),
                entity.isLocked(),
                entity.getFailedAttempts(),
                entity.getProfessionalId(),
                entity.getPatientId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public UserJpaEntity toJpa(User domain, Set<RoleJpaEntity> existingRoleEntities) {
        if (domain == null) return null;

        return new UserJpaEntity(
                domain.getId().value(),
                domain.getEmail().value(),
                domain.getPasswordHash().value(),
                domain.isActive(),
                domain.isLocked(),
                domain.getFailedAttempts(),
                domain.getProfessionalId(),
                domain.getPatientId(),
                domain.getCreatedAt(),
                domain.getUpdatedAt(),
                existingRoleEntities != null ? existingRoleEntities : new HashSet<>()
        );
    }
}
