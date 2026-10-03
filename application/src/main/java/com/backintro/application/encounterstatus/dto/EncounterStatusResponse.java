package com.backintro.application.encounterstatus.dto;

import java.util.UUID;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;

public record EncounterStatusResponse(UUID id, String name, String code, boolean active) {
    public static EncounterStatusResponse fromDomain(EncounterStatus aggregate) {
        return new EncounterStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
