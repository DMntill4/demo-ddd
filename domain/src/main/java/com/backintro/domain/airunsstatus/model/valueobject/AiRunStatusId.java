package com.backintro.domain.airunsstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record AiRunStatusId(UUID value) {
    public AiRunStatusId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static AiRunStatusId generate() {
        return new AiRunStatusId(UUID.randomUUID());
    }
}
