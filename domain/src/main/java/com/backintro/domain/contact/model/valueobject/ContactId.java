package com.backintro.domain.contact.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ContactId(UUID value) {
    public ContactId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static ContactId generate() {
        return new ContactId(UUID.randomUUID());
    }
}
