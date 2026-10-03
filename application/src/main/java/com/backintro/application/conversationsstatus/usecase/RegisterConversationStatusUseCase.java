package com.backintro.application.conversationsstatus.usecase;

import com.backintro.application.conversationsstatus.command.RegisterConversationStatusCommand;
import com.backintro.application.conversationsstatus.dto.ConversationStatusResponse;
import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;

public class RegisterConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public RegisterConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(RegisterConversationStatusCommand command) {
        ConversationStatus aggregate = ConversationStatus.register(command.nameStatus());
        ConversationStatus saved = repository.save(aggregate);
        return ConversationStatusResponse.fromDomain(saved);
    }
}
