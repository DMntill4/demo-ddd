package com.backintro.application.chatairun.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public class ChatAiRunNotFoundApplicationException extends ApplicationException {
    public ChatAiRunNotFoundApplicationException(ChatAiRunId id) {
        super("ChatAiRun with id " + id.value() + " was not found.");
    }
}
