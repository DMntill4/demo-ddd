package com.backintro.domain.phonecontact.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public class PhoneContactNotFoundException extends DomainException {
    public PhoneContactNotFoundException(PhoneContactId id) {
        super("PhoneContact with id " + id.value() + " was not found.");
    }
}
