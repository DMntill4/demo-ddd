package com.backintro.application.chatairunerror.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public class ChatAiRunErrorNotFoundApplicationException extends ApplicationException {
    public ChatAiRunErrorNotFoundApplicationException(ChatAiRunErrorId id) {
        super("ChatAiRunError with id " + id.value() + " was not found.");
    }
}
