package com.backintro.application.airunstatus.dto;

import java.util.UUID;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;

public record AiRunStatusResponse(UUID id, String name, String code, boolean active) {
    public static AiRunStatusResponse fromDomain(AiRunStatus aggregate) {
        return new AiRunStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
