package com.backintro.application.encounterstatuss.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;

public class EncounterStatusNotFoundApplicationException extends ApplicationException {
    public EncounterStatusNotFoundApplicationException(EncounterStatusId id) {
        super("EncounterStatus with id " + id.value() + " was not found.");
    }
}
