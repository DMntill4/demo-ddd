package com.backintro.domain.chatescalationassignment.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public class ChatEscalationAssignmentNotFoundException extends DomainException {
    public ChatEscalationAssignmentNotFoundException(ChatEscalationAssignmentId id) {
        super("ChatEscalationAssignment with id " + id.value() + " was not found.");
    }
}
