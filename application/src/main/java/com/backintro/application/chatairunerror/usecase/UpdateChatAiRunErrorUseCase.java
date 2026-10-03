package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.command.UpdateChatAiRunErrorCommand;
import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class UpdateChatAiRunErrorUseCase {
    private final ChatAiRunErrorRepository repository;

    public UpdateChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunErrorResponse execute(UpdateChatAiRunErrorCommand command) {
        ChatAiRunError aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(command.id()));
        aggregate.update(command.aiRunId(), command.errorMessage(), command.errorCode(), command.providerErrorId());
        ChatAiRunError saved = repository.save(aggregate);
        return ChatAiRunErrorResponse.fromDomain(saved);
    }
}
