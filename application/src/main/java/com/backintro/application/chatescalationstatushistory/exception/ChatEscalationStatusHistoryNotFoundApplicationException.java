package com.backintro.application.chatescalationstatushistory.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public class ChatEscalationStatusHistoryNotFoundApplicationException extends ApplicationException {
    public ChatEscalationStatusHistoryNotFoundApplicationException(ChatEscalationStatusHistoryId id) {
        super("ChatEscalationStatusHistory with id " + id.value() + " was not found.");
    }
}
