package com.backintro.infrastructure.emailcontact.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateEmailContactRequest(UUID contactId, String email, String notes) {
}
