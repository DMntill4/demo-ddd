package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.command.UpdateChatEscalationStatusHistoryCommand;
import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class UpdateChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;

    public UpdateChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationStatusHistoryResponse execute(UpdateChatEscalationStatusHistoryCommand command) {
        ChatEscalationStatusHistory aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(command.id()));
        aggregate.update(command.escalationId(), command.escalationStatusId(), command.changedAt());
        ChatEscalationStatusHistory saved = repository.save(aggregate);
        return ChatEscalationStatusHistoryResponse.fromDomain(saved);
    }
}
