package com.backintro.application.encountermodality.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public class EncounterModalityNotFoundApplicationException extends ApplicationException {
    public EncounterModalityNotFoundApplicationException(EncounterModalityId id) {
        super("EncounterModality with id " + id.value() + " was not found.");
    }
}
