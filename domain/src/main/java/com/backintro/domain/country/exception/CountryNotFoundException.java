package com.backintro.domain.country.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.country.model.valueobject.CountryId;

public class CountryNotFoundException extends DomainException {
    public CountryNotFoundException(CountryId id) {
        super("Country with id " + id.value() + " was not found.");
    }
}
