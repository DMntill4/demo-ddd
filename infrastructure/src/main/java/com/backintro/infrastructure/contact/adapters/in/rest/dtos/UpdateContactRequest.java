package com.backintro.infrastructure.contact.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateContactRequest(String fullName, String email, String notes, UUID cityId, UUID createdBy, UUID updatedBy) {
}
