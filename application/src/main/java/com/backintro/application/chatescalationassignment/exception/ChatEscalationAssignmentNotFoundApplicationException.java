package com.backintro.application.chatescalationassignment.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public class ChatEscalationAssignmentNotFoundApplicationException extends ApplicationException {
    public ChatEscalationAssignmentNotFoundApplicationException(ChatEscalationAssignmentId id) {
        super("ChatEscalationAssignment with id " + id.value() + " was not found.");
    }
}
