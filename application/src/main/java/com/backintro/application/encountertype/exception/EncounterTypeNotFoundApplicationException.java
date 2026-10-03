package com.backintro.application.encountertype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public class EncounterTypeNotFoundApplicationException extends ApplicationException {
    public EncounterTypeNotFoundApplicationException(EncounterTypeId id) {
        super("EncounterType with id " + id.value() + " was not found.");
    }
}
