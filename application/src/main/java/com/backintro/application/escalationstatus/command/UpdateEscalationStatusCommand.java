package com.backintro.application.escalationstatus.command;

import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public record UpdateEscalationStatusCommand(EscalationStatusId id, String name, String code) {
}
