package com.backintro.domain.chatescalationstatushistory.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public class ChatEscalationStatusHistoryNotFoundException extends DomainException {
    public ChatEscalationStatusHistoryNotFoundException(ChatEscalationStatusHistoryId id) {
        super("ChatEscalationStatusHistory with id " + id.value() + " was not found.");
    }
}
