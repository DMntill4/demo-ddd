package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.command.UpdateChatAiRunCommand;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class UpdateChatAiRunUseCase {
    private final ChatAiRunRepository repository;

    public UpdateChatAiRunUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunResponse execute(UpdateChatAiRunCommand command) {
        ChatAiRun aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(command.id()));
        aggregate.update(command.conversationId(), command.messageId(), command.modelId(), command.aiRunStatusId());
        ChatAiRun saved = repository.save(aggregate);
        return ChatAiRunResponse.fromDomain(saved);
    }
}
