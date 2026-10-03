package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;

public class DeleteChatEscalationUseCase {
    private final ChatEscalationRepository repository;

    public DeleteChatEscalationUseCase(ChatEscalationRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatEscalationId id) {
        ChatEscalation aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
