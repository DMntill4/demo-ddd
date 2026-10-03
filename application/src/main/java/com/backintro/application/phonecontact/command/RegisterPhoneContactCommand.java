package com.backintro.application.phonecontact.command;

import java.util.UUID;

public record RegisterPhoneContactCommand(UUID contactId, String phone, String notes) {
}
