package com.backintro.application.airunsstatus.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;

public record AiRunStatusResponse(UUID id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static AiRunStatusResponse fromDomain(AiRunStatus aggregate) {
        return new AiRunStatusResponse(aggregate.id().value(), aggregate.nameStatus(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
