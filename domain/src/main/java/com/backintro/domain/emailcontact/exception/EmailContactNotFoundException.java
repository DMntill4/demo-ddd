package com.backintro.domain.emailcontact.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public class EmailContactNotFoundException extends DomainException {
    public EmailContactNotFoundException(EmailContactId id) {
        super("EmailContact with id " + id.value() + " was not found.");
    }
}
