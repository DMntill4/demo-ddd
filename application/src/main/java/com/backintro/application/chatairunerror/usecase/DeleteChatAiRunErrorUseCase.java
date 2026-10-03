package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class DeleteChatAiRunErrorUseCase {
    private final ChatAiRunErrorRepository repository;

    public DeleteChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatAiRunErrorId id) {
        ChatAiRunError aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
