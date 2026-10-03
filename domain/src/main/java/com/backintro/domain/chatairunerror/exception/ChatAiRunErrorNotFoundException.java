package com.backintro.domain.chatairunerror.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public class ChatAiRunErrorNotFoundException extends DomainException {
    public ChatAiRunErrorNotFoundException(ChatAiRunErrorId id) {
        super("ChatAiRunError with id " + id.value() + " was not found.");
    }
}
