package com.backintro.domain.chatairun.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public class ChatAiRunNotFoundException extends DomainException {
    public ChatAiRunNotFoundException(ChatAiRunId id) {
        super("ChatAiRun with id " + id.value() + " was not found.");
    }
}
