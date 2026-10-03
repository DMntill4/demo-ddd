package com.backintro.application.sendertype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public class SenderTypeNotFoundApplicationException extends ApplicationException {
    public SenderTypeNotFoundApplicationException(SenderTypeId id) {
        super("SenderType with id " + id.value() + " was not found.");
    }
}
