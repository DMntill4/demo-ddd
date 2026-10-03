package com.backintro.domain.priority.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.priority.model.valueobject.PriorityId;

public class PriorityNotFoundException extends DomainException {
    public PriorityNotFoundException(PriorityId id) {
        super("Priority with id " + id.value() + " was not found.");
    }
}
