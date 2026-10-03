package com.backintro.application.emailcontact.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public class EmailContactNotFoundApplicationException extends ApplicationException {
    public EmailContactNotFoundApplicationException(EmailContactId id) {
        super("EmailContact with id " + id.value() + " was not found.");
    }
}
