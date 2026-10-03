package com.backintro.application.treatmentgoalstatus.dto;

import java.util.UUID;
import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;

public record TreatmentGoalStatusResponse(UUID id, String name, String code, boolean active) {
    public static TreatmentGoalStatusResponse fromDomain(TreatmentGoalStatus aggregate) {
        return new TreatmentGoalStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
