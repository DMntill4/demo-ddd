package com.backintro.domain.treatmentplan.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentPlanId(UUID value) {
    public TreatmentPlanId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static TreatmentPlanId generate() {
        return new TreatmentPlanId(UUID.randomUUID());
    }
}
