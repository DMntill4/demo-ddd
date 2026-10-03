package com.backintro.domain.contact.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.contact.model.valueobject.ContactId;

public class ContactNotFoundException extends DomainException {
    public ContactNotFoundException(ContactId id) {
        super("Contact with id " + id.value() + " was not found.");
    }
}
