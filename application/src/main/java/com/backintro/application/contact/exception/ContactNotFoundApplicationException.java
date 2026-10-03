package com.backintro.application.contact.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.contact.model.valueobject.ContactId;

public class ContactNotFoundApplicationException extends ApplicationException {
    public ContactNotFoundApplicationException(ContactId id) {
        super("Contact with id " + id.value() + " was not found.");
    }
}
