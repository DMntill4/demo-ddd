package com.backintro.domain.encountertype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public class EncounterTypeNotFoundException extends DomainException {
    public EncounterTypeNotFoundException(EncounterTypeId id) {
        super("EncounterType with id " + id.value() + " was not found.");
    }
}
