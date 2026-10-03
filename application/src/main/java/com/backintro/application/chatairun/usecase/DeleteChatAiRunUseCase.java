package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class DeleteChatAiRunUseCase {
    private final ChatAiRunRepository repository;

    public DeleteChatAiRunUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatAiRunId id) {
        ChatAiRun aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
