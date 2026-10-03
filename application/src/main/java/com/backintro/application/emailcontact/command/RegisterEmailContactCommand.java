package com.backintro.application.emailcontact.command;

import java.util.UUID;

public record RegisterEmailContactCommand(UUID contactId, String email, String notes) {
}
