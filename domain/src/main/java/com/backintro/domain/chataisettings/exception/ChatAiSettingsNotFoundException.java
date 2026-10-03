package com.backintro.domain.chataisettings.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;

public class ChatAiSettingsNotFoundException extends DomainException {
    public ChatAiSettingsNotFoundException(ChatAiSettingsId id) {
        super("ChatAiSettings with id " + id.value() + " was not found.");
    }
}
