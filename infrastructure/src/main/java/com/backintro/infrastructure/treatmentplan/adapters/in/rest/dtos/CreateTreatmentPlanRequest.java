package com.backintro.infrastructure.treatmentplan.adapters.in.rest.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTreatmentPlanRequest(UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId) {
}
