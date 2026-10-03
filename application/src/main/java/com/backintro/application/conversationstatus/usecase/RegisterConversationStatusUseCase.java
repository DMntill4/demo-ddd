package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.command.RegisterConversationStatusCommand;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class RegisterConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public RegisterConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(RegisterConversationStatusCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("ConversationStatus code already exists: " + command.code());
        }
        ConversationStatus aggregate = ConversationStatus.register(command.name(), command.code());
        ConversationStatus saved = repository.save(aggregate);
        return ConversationStatusResponse.fromDomain(saved);
    }
}
