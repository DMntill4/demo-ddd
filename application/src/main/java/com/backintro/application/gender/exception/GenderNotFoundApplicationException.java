package com.backintro.application.gender.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.gender.model.valueobject.GenderId;

public class GenderNotFoundApplicationException extends ApplicationException {
    public GenderNotFoundApplicationException(GenderId id) {
        super("Gender with id " + id.value() + " was not found.");
    }
}
