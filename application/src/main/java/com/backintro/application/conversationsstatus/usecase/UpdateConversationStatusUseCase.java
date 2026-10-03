package com.backintro.application.conversationsstatus.usecase;

import com.backintro.application.conversationsstatus.command.UpdateConversationStatusCommand;
import com.backintro.application.conversationsstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationsstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;

public class UpdateConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public UpdateConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(UpdateConversationStatusCommand command) {
        ConversationStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.nameStatus());
        ConversationStatus saved = repository.save(aggregate);
        return ConversationStatusResponse.fromDomain(saved);
    }
}
