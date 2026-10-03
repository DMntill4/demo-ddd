package com.backintro.application.consenttype.command;

import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public record UpdateConsentTypeCommand(ConsentTypeId id, String code, String name, String description) {
}
