package com.backintro.application.stateregion.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public class StateRegionNotFoundApplicationException extends ApplicationException {
    public StateRegionNotFoundApplicationException(StateRegionId id) {
        super("StateRegion with id " + id.value() + " was not found.");
    }
}
