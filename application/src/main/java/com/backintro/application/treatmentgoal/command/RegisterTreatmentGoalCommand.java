package com.backintro.application.treatmentgoal.command;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

public record RegisterTreatmentGoalCommand(UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId) {
}
