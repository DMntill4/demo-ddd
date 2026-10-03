package com.backintro.application.encounter.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.encounter.model.valueobject.EncounterId;

public class EncounterNotFoundApplicationException extends ApplicationException {
    public EncounterNotFoundApplicationException(EncounterId id) {
        super("Encounter with id " + id.value() + " was not found.");
    }
}
