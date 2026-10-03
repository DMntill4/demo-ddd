package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.command.RegisterChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class RegisterChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;

    public RegisterChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationAssignmentResponse execute(RegisterChatEscalationAssignmentCommand command) {
        ChatEscalationAssignment aggregate = ChatEscalationAssignment.register(command.escalationId(), command.professionalId(), command.assignedAt());
        ChatEscalationAssignment saved = repository.save(aggregate);
        return ChatEscalationAssignmentResponse.fromDomain(saved);
    }
}
