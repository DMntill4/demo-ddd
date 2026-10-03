package com.backintro.application.encounterstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public class EncounterStatusNotFoundApplicationException extends ApplicationException {
    public EncounterStatusNotFoundApplicationException(EncounterStatusId id) {
        super("EncounterStatus with id " + id.value() + " was not found.");
    }
}
