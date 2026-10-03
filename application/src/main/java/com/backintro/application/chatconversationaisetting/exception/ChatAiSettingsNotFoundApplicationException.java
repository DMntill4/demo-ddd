package com.backintro.application.chatconversationaisetting.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;

public class ChatAiSettingsNotFoundApplicationException extends ApplicationException {
    public ChatAiSettingsNotFoundApplicationException(ChatAiSettingsId id) {
        super("ChatAiSettings with id " + id.value() + " was not found.");
    }
}
