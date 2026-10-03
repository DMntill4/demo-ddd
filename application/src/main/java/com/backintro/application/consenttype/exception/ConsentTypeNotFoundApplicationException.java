package com.backintro.application.consenttype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public class ConsentTypeNotFoundApplicationException extends ApplicationException {
    public ConsentTypeNotFoundApplicationException(ConsentTypeId id) {
        super("ConsentType with id " + id.value() + " was not found.");
    }
}
