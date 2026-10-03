package com.backintro.infrastructure.encounter.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateEncounterRequest(UUID clinicalRecordId, UUID professionalId, UUID encounterTypeId, LocalDateTime startedAt, LocalDateTime endedAt, String reasonForVisit, String currentCondition, UUID modalityId, UUID statusId, UUID createdBy, UUID updatedBy) {
}
