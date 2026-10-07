package com.backintro.infrastructure.auth.adapters.out.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backintro.domain.auth.model.valueobject.PasswordHash;
import com.backintro.domain.auth.port.security.PasswordHasherPort;

@Component
public class BCryptPasswordHasherAdapter implements PasswordHasherPort {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordHasherAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public PasswordHash hash(String plainPassword) {
        return PasswordHash.of(passwordEncoder.encode(plainPassword));
    }

    @Override
    public boolean matches(String plainPassword, PasswordHash passwordHash) {
        return passwordEncoder.matches(plainPassword, passwordHash.value());
    }
}
