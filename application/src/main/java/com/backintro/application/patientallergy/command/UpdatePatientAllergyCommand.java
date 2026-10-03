package com.backintro.application.patientallergy.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public record UpdatePatientAllergyCommand(PatientAllergyId id, UUID patientId, String substance, String reaction, String severity, LocalDateTime recordedAt, UUID recordedBy) {
}
