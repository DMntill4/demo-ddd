package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.command.UpdateChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class UpdateChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;

    public UpdateChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationAssignmentResponse execute(UpdateChatEscalationAssignmentCommand command) {
        ChatEscalationAssignment aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(command.id()));
        aggregate.update(command.escalationId(), command.professionalId(), command.assignedAt());
        ChatEscalationAssignment saved = repository.save(aggregate);
        return ChatEscalationAssignmentResponse.fromDomain(saved);
    }
}
