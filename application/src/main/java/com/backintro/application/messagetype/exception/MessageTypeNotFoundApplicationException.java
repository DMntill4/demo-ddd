package com.backintro.application.messagetype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public class MessageTypeNotFoundApplicationException extends ApplicationException {
    public MessageTypeNotFoundApplicationException(MessageTypeId id) {
        super("MessageType with id " + id.value() + " was not found.");
    }
}
