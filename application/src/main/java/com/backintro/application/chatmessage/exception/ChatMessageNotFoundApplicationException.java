package com.backintro.application.chatmessage.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public class ChatMessageNotFoundApplicationException extends ApplicationException {
    public ChatMessageNotFoundApplicationException(ChatMessageId id) {
        super("ChatMessage with id " + id.value() + " was not found.");
    }
}
