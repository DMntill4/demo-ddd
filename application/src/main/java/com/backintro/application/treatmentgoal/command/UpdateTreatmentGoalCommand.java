package com.backintro.application.treatmentgoal.command;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public record UpdateTreatmentGoalCommand(TreatmentGoalId id, UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId) {
}
