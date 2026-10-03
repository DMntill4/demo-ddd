package com.backintro.application.conversationstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;

public class ConversationStatusNotFoundApplicationException extends ApplicationException {
    public ConversationStatusNotFoundApplicationException(ConversationStatusId id) {
        super("ConversationStatus with id " + id.value() + " was not found.");
    }
}
