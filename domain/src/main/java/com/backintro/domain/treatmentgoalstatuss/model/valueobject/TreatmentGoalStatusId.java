package com.backintro.domain.treatmentgoalstatuss.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentGoalStatusId(UUID value) {
    public TreatmentGoalStatusId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static TreatmentGoalStatusId generate() {
        return new TreatmentGoalStatusId(UUID.randomUUID());
    }
}
