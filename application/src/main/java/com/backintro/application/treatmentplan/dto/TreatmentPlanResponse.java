package com.backintro.application.treatmentplan.dto;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;

public record TreatmentPlanResponse(UUID id, UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static TreatmentPlanResponse fromDomain(TreatmentPlan aggregate) {
        return new TreatmentPlanResponse(aggregate.id().value(), aggregate.encounterId(), aggregate.professionalId(), aggregate.title(), aggregate.description(), aggregate.startDate(), aggregate.endDate(), aggregate.treatmentStatusId(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
