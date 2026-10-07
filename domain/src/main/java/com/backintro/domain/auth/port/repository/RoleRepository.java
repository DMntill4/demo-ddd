package com.backintro.domain.auth.port.repository;

import java.util.Optional;

import com.backintro.domain.auth.model.entity.Role;

public interface RoleRepository {
    Optional<Role> findByName(String name);
    Role save(Role role);
}
