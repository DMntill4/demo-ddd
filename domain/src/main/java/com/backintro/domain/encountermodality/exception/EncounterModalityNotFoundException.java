package com.backintro.domain.encountermodality.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public class EncounterModalityNotFoundException extends DomainException {
    public EncounterModalityNotFoundException(EncounterModalityId id) {
        super("EncounterModality with id " + id.value() + " was not found.");
    }
}
