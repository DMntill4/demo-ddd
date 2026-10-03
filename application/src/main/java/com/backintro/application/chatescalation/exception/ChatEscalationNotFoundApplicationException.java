package com.backintro.application.chatescalation.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public class ChatEscalationNotFoundApplicationException extends ApplicationException {
    public ChatEscalationNotFoundApplicationException(ChatEscalationId id) {
        super("ChatEscalation with id " + id.value() + " was not found.");
    }
}
