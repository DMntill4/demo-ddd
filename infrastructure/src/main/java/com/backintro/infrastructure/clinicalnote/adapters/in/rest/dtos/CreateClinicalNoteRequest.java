package com.backintro.infrastructure.clinicalnote.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateClinicalNoteRequest(UUID encounterId, UUID professionalId, String subjective, String objective, String assessment, String plan, String additionalNotes, LocalDateTime signedAt) {
}
