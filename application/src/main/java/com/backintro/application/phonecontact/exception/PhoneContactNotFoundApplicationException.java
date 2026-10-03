package com.backintro.application.phonecontact.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public class PhoneContactNotFoundApplicationException extends ApplicationException {
    public PhoneContactNotFoundApplicationException(PhoneContactId id) {
        super("PhoneContact with id " + id.value() + " was not found.");
    }
}
