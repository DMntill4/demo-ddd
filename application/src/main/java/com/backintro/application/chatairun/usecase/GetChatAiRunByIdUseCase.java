package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class GetChatAiRunByIdUseCase {
    private final ChatAiRunRepository repository;

    public GetChatAiRunByIdUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunResponse execute(ChatAiRunId id) {
        return repository.findById(id)
                .map(ChatAiRunResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id));
    }
}
