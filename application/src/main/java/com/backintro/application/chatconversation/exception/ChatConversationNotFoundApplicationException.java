package com.backintro.application.chatconversation.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public class ChatConversationNotFoundApplicationException extends ApplicationException {
    public ChatConversationNotFoundApplicationException(ChatConversationId id) {
        super("ChatConversation with id " + id.value() + " was not found.");
    }
}
