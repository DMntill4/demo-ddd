package com.backintro.infrastructure.professional.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateProfessionalRequest(UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, UUID cityId) {
}
