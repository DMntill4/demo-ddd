package com.backintro.application.chataisettings.usecase;

import com.backintro.application.chataisettings.command.RegisterChatAiSettingsCommand;
import com.backintro.application.chataisettings.dto.ChatAiSettingsResponse;
import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;

public class RegisterChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public RegisterChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public ChatAiSettingsResponse execute(RegisterChatAiSettingsCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("ChatAiSettings code already exists: " + command.code());
        }
        ChatAiSettings aggregate = ChatAiSettings.register(command.name(), command.code());
        ChatAiSettings saved = repository.save(aggregate);
        return ChatAiSettingsResponse.fromDomain(saved);
    }
}
