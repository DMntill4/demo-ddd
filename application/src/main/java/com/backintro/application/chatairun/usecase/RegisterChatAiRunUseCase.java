package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.command.RegisterChatAiRunCommand;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class RegisterChatAiRunUseCase {
    private final ChatAiRunRepository repository;

    public RegisterChatAiRunUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunResponse execute(RegisterChatAiRunCommand command) {
        ChatAiRun aggregate = ChatAiRun.register(command.conversationId(), command.messageId(), command.modelId(), command.aiRunStatusId());
        ChatAiRun saved = repository.save(aggregate);
        return ChatAiRunResponse.fromDomain(saved);
    }
}
