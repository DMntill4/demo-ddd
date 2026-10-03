package com.backintro.domain.encounterstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public class EncounterStatusNotFoundException extends DomainException {
    public EncounterStatusNotFoundException(EncounterStatusId id) {
        super("EncounterStatus with id " + id.value() + " was not found.");
    }
}
