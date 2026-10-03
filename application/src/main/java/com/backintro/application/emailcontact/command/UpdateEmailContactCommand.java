package com.backintro.application.emailcontact.command;

import java.util.UUID;

import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public record UpdateEmailContactCommand(EmailContactId id, UUID contactId, String email, String notes) {
}
