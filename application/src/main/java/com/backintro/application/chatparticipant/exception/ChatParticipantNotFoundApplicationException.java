package com.backintro.application.chatparticipant.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public class ChatParticipantNotFoundApplicationException extends ApplicationException {
    public ChatParticipantNotFoundApplicationException(ChatParticipantId id) {
        super("ChatParticipant with id " + id.value() + " was not found.");
    }
}
