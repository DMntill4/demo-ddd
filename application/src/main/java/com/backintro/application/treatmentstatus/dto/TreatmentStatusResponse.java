package com.backintro.application.treatmentstatus.dto;

import java.util.UUID;
import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;

public record TreatmentStatusResponse(UUID id, String name, String code, boolean active) {
    public static TreatmentStatusResponse fromDomain(TreatmentStatus aggregate) {
        return new TreatmentStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
