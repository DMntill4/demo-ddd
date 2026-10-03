package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class GetChatEscalationAssignmentByIdUseCase {
    private final ChatEscalationAssignmentRepository repository;

    public GetChatEscalationAssignmentByIdUseCase(ChatEscalationAssignmentRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationAssignmentResponse execute(ChatEscalationAssignmentId id) {
        return repository.findById(id)
                .map(ChatEscalationAssignmentResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id));
    }
}
