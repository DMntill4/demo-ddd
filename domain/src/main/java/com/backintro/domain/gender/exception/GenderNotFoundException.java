package com.backintro.domain.gender.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.gender.model.valueobject.GenderId;

public class GenderNotFoundException extends DomainException {
    public GenderNotFoundException(GenderId id) {
        super("Gender with id " + id.value() + " was not found.");
    }
}
