package com.backintro.application.encounter.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.encounter.model.valueobject.EncounterId;

public record UpdateEncounterCommand(EncounterId id, UUID clinicalRecordId, UUID professionalId, UUID encounterTypeId, LocalDateTime startedAt, LocalDateTime endedAt, String reasonForVisit, String currentCondition, UUID modalityId, UUID statusId, UUID createdBy, UUID updatedBy) {
}
