package com.backintro.application.chatescalationstatushistory.usecase;

import java.util.List;
import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class ListChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;

    public ListChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public List<ChatEscalationStatusHistoryResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatEscalationStatusHistoryResponse::fromDomain)
                .toList();
    }
}
