package com.backintro.application.assessmenttype.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;

public record AssessmentTypeResponse(UUID id, String code, String name, boolean active, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static AssessmentTypeResponse fromDomain(AssessmentType aggregate) {
        return new AssessmentTypeResponse(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.description(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
