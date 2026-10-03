package com.backintro.infrastructure.phonecontact.adapters.in.rest.dtos;

import java.util.UUID;

public record CreatePhoneContactRequest(UUID contactId, String phone, String notes) {
}
