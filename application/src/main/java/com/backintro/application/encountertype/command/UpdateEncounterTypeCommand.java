package com.backintro.application.encountertype.command;

import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public record UpdateEncounterTypeCommand(EncounterTypeId id, String code, String name) {
}
