package com.backintro.domain.chatmessage.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public class ChatMessageNotFoundException extends DomainException {
    public ChatMessageNotFoundException(ChatMessageId id) {
        super("ChatMessage with id " + id.value() + " was not found.");
    }
}
