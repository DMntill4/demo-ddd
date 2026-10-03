package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class GetChatAiRunErrorByIdUseCase {
    private final ChatAiRunErrorRepository repository;

    public GetChatAiRunErrorByIdUseCase(ChatAiRunErrorRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunErrorResponse execute(ChatAiRunErrorId id) {
        return repository.findById(id)
                .map(ChatAiRunErrorResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id));
    }
}
