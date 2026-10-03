package com.backintro.application.encounterstatuss.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;

public record EncounterStatusResponse(UUID id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static EncounterStatusResponse fromDomain(EncounterStatus aggregate) {
        return new EncounterStatusResponse(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
