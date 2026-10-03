package com.backintro.application.professional.command;

import java.util.UUID;

public record RegisterProfessionalCommand(UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, UUID cityId) {
}
