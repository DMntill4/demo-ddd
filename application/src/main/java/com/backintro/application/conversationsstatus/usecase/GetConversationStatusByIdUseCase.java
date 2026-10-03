package com.backintro.application.conversationsstatus.usecase;

import com.backintro.application.conversationsstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationsstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;

public class GetConversationStatusByIdUseCase {
    private final ConversationStatusRepository repository;

    public GetConversationStatusByIdUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(ConversationStatusId id) {
        return repository.findById(id)
                .map(ConversationStatusResponse::fromDomain)
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(id));
    }
}
