package com.backintro.application.treatmentstatuss.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;

public record TreatmentStatusResponse(UUID id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static TreatmentStatusResponse fromDomain(TreatmentStatus aggregate) {
        return new TreatmentStatusResponse(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
