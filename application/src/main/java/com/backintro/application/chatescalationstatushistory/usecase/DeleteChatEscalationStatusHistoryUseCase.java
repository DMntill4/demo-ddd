package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class DeleteChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;

    public DeleteChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatEscalationStatusHistoryId id) {
        ChatEscalationStatusHistory aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
