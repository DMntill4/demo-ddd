package com.backintro.domain.chatescalation.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public class ChatEscalationNotFoundException extends DomainException {
    public ChatEscalationNotFoundException(ChatEscalationId id) {
        super("ChatEscalation with id " + id.value() + " was not found.");
    }
}
