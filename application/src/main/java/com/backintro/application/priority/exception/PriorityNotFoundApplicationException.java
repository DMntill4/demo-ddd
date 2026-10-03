package com.backintro.application.priority.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.priority.model.valueobject.PriorityId;

public class PriorityNotFoundApplicationException extends ApplicationException {
    public PriorityNotFoundApplicationException(PriorityId id) {
        super("Priority with id " + id.value() + " was not found.");
    }
}
