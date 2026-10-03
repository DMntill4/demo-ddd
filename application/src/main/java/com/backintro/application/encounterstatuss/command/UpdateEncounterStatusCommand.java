package com.backintro.application.encounterstatuss.command;

import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;

public record UpdateEncounterStatusCommand(EncounterStatusId id, String code, String name) {
}
