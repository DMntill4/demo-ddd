package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class DeleteChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;

    public DeleteChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatEscalationAssignmentId id) {
        ChatEscalationAssignment aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
