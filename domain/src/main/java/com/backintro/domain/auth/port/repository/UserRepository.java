package com.backintro.domain.auth.port.repository;

import java.util.Optional;

import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.model.valueobject.UserId;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId id);
    Optional<User> findByEmail(Email email);
    boolean existsByEmail(Email email);
}
