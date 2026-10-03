package com.backintro.domain.conversationsstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;

public class ConversationStatusNotFoundException extends DomainException {
    public ConversationStatusNotFoundException(ConversationStatusId id) {
        super("ConversationStatus with id " + id.value() + " was not found.");
    }
}
