package com.backintro.domain.encounterstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EncounterStatusId(UUID value) {
    public EncounterStatusId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static EncounterStatusId generate() {
        return new EncounterStatusId(UUID.randomUUID());
    }
}
