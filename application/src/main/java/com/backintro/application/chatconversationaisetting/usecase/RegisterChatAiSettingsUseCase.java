package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.command.RegisterChatAiSettingsCommand;
import com.backintro.application.chatconversationaisetting.dto.ChatAiSettingsResponse;
import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;

public class RegisterChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public RegisterChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public ChatAiSettingsResponse execute(RegisterChatAiSettingsCommand command) {
        ChatAiSettings aggregate = ChatAiSettings.register(command.conversationId(), command.aiEnabled(), command.defaultModelId());
        ChatAiSettings saved = repository.save(aggregate);
        return ChatAiSettingsResponse.fromDomain(saved);
    }
}
