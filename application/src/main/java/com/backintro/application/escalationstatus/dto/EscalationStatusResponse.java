package com.backintro.application.escalationstatus.dto;

import java.util.UUID;
import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;

public record EscalationStatusResponse(UUID id, String name, String code, boolean active) {
    public static EscalationStatusResponse fromDomain(EscalationStatus aggregate) {
        return new EscalationStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
