package com.backintro.domain.priority.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PriorityId(UUID value) {
    public PriorityId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static PriorityId generate() {
        return new PriorityId(UUID.randomUUID());
    }
}
