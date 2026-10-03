package com.backintro.infrastructure.treatmentgoal.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

public record CreateTreatmentGoalRequest(UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId) {
}
