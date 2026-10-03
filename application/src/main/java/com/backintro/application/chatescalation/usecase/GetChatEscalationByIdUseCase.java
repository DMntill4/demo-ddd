package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;

public class GetChatEscalationByIdUseCase {
    private final ChatEscalationRepository repository;

    public GetChatEscalationByIdUseCase(ChatEscalationRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationResponse execute(ChatEscalationId id) {
        return repository.findById(id)
                .map(ChatEscalationResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id));
    }
}
