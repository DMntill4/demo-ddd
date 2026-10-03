package com.backintro.application.contact.command;

import java.util.UUID;

import com.backintro.domain.contact.model.valueobject.ContactId;

public record UpdateContactCommand(ContactId id, String fullName, String email, String notes, UUID cityId, UUID createdBy, UUID updatedBy) {
}
