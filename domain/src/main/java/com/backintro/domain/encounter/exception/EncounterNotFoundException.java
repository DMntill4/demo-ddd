package com.backintro.domain.encounter.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.encounter.model.valueobject.EncounterId;

public class EncounterNotFoundException extends DomainException {
    public EncounterNotFoundException(EncounterId id) {
        super("Encounter with id " + id.value() + " was not found.");
    }
}
