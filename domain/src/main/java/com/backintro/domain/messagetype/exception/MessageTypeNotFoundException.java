package com.backintro.domain.messagetype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public class MessageTypeNotFoundException extends DomainException {
    public MessageTypeNotFoundException(MessageTypeId id) {
        super("MessageType with id " + id.value() + " was not found.");
    }
}
