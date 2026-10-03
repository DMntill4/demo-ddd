package com.backintro.domain.sendertype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public class SenderTypeNotFoundException extends DomainException {
    public SenderTypeNotFoundException(SenderTypeId id) {
        super("SenderType with id " + id.value() + " was not found.");
    }
}
