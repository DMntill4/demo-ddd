package com.backintro.application.conversationstatus.usecase;

import java.util.List;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class ListConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public ListConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public List<ConversationStatusResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ConversationStatusResponse::fromDomain)
                .toList();
    }
}
