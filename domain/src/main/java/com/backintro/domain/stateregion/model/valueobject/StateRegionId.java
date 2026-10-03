package com.backintro.domain.stateregion.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record StateRegionId(UUID value) {
    public StateRegionId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static StateRegionId generate() {
        return new StateRegionId(UUID.randomUUID());
    }
}
