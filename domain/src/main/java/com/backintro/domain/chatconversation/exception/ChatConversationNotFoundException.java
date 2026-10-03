package com.backintro.domain.chatconversation.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public class ChatConversationNotFoundException extends DomainException {
    public ChatConversationNotFoundException(ChatConversationId id) {
        super("ChatConversation with id " + id.value() + " was not found.");
    }
}
