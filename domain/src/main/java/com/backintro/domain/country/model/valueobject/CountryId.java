package com.backintro.domain.country.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record CountryId(UUID value) {
    public CountryId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static CountryId generate() {
        return new CountryId(UUID.randomUUID());
    }
}
