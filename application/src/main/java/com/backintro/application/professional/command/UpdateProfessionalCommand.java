package com.backintro.application.professional.command;

import java.util.UUID;

import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public record UpdateProfessionalCommand(ProfessionalId id, UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, UUID cityId) {
}
