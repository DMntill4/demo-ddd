package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

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
