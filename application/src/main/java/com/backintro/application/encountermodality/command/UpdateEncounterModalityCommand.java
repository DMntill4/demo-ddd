package com.backintro.application.encountermodality.command;

import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public record UpdateEncounterModalityCommand(EncounterModalityId id, String code, String name) {
}
