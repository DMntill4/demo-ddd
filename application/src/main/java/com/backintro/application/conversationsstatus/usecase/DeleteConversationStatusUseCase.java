package com.backintro.application.conversationsstatus.usecase;

import com.backintro.application.conversationsstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;

public class DeleteConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public DeleteConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(ConversationStatusId id) {
        ConversationStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
