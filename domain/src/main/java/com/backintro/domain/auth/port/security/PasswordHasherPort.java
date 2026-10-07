package com.backintro.domain.auth.port.security;

import com.backintro.domain.auth.model.valueobject.PasswordHash;

public interface PasswordHasherPort {
    PasswordHash hash(String plainPassword);
    boolean matches(String plainPassword, PasswordHash passwordHash);
}
