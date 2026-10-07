package com.backintro.domain.auth.model.valueobject;

import java.util.Objects;

public record PasswordHash(String value) {
    public PasswordHash {
        Objects.requireNonNull(value, "Password hash must not be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Password hash must not be empty");
        }
    }

    public static PasswordHash of(String value) {
        return new PasswordHash(value);
    }
}
