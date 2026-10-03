package com.backintro.domain.chatparticipant.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public class ChatParticipantNotFoundException extends DomainException {
    public ChatParticipantNotFoundException(ChatParticipantId id) {
        super("ChatParticipant with id " + id.value() + " was not found.");
    }
}
