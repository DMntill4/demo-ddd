package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class GetChatEscalationStatusHistoryByIdUseCase {
    private final ChatEscalationStatusHistoryRepository repository;

    public GetChatEscalationStatusHistoryByIdUseCase(ChatEscalationStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationStatusHistoryResponse execute(ChatEscalationStatusHistoryId id) {
        return repository.findById(id)
                .map(ChatEscalationStatusHistoryResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(id));
    }
}
