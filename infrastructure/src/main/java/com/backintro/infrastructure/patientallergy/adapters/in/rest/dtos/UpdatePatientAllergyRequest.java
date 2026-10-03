package com.backintro.infrastructure.patientallergy.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdatePatientAllergyRequest(UUID patientId, String substance, String reaction, String severity, LocalDateTime recordedAt, UUID recordedBy) {
}
