package com.backintro.application.professional.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.professional.model.aggregate.Professional;

public record ProfessionalResponse(UUID id, UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, boolean active, UUID cityId, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static ProfessionalResponse fromDomain(Professional aggregate) {
        return new ProfessionalResponse(aggregate.id().value(), aggregate.documentTypeId(), aggregate.documentNumber(), aggregate.firstName(), aggregate.lastName(), aggregate.professionalTypeId(), aggregate.licenseNumber(), aggregate.active(), aggregate.cityId(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
