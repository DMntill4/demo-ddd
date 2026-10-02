package com.demodd.application.country.exception;

import com.demodd.application.common.exception.ApplicationException;

public class CountryNotFoundApplicationException
        extends ApplicationException {

    public CountryNotFoundApplicationException(String message) {
        super(message);
    }
}
