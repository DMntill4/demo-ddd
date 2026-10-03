package com.backintro.application.encounterstatus.command;

import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public record UpdateEncounterStatusCommand(EncounterStatusId id, String name, String code) {
}
