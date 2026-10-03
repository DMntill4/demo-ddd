package com.backintro.domain.consenttype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public class ConsentTypeNotFoundException extends DomainException {
    public ConsentTypeNotFoundException(ConsentTypeId id) {
        super("ConsentType with id " + id.value() + " was not found.");
    }
}
