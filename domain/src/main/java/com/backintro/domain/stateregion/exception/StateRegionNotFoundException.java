package com.backintro.domain.stateregion.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public class StateRegionNotFoundException extends DomainException {
    public StateRegionNotFoundException(StateRegionId id) {
        super("StateRegion with id " + id.value() + " was not found.");
    }
}
