package com.backintro.domain.risklevel.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record RiskLevelId(UUID value) {
    public RiskLevelId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static RiskLevelId generate() {
        return new RiskLevelId(UUID.randomUUID());
    }
}
