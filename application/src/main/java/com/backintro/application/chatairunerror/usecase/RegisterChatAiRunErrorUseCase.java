package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.command.RegisterChatAiRunErrorCommand;
import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class RegisterChatAiRunErrorUseCase {
    private final ChatAiRunErrorRepository repository;

    public RegisterChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunErrorResponse execute(RegisterChatAiRunErrorCommand command) {
        ChatAiRunError aggregate = ChatAiRunError.register(command.aiRunId(), command.errorMessage(), command.errorCode(), command.providerErrorId());
        ChatAiRunError saved = repository.save(aggregate);
        return ChatAiRunErrorResponse.fromDomain(saved);
    }
}
