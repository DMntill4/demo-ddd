package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.command.UpdateConversationStatusCommand;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class UpdateConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public UpdateConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(UpdateConversationStatusCommand command) {
        ConversationStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        ConversationStatus saved = repository.save(aggregate);
        return ConversationStatusResponse.fromDomain(saved);
    }
}
