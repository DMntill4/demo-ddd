package com.backintro.application.country.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.country.model.valueobject.CountryId;

public class CountryNotFoundApplicationException extends ApplicationException {
    public CountryNotFoundApplicationException(CountryId id) {
        super("Country with id " + id.value() + " was not found.");
    }
}
