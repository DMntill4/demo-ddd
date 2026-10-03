package com.backintro.application.escalationsstatus.command;

import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public record UpdateEscalationStatusCommand(EscalationStatusId id, String nameStatus) {
}
