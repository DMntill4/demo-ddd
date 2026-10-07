package com.backintro.domain.auth.model.valueobject;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    public Email {
        Objects.requireNonNull(value, "Email must not be null");
        String trimmed = value.trim().toLowerCase();
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
        value = trimmed;
    }

    public static Email of(String value) {
        return new Email(value);
    }
}
