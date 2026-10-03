package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.command.UpdateChatAiSettingsCommand;
import com.backintro.application.chatconversationaisetting.dto.ChatAiSettingsResponse;
import com.backintro.application.chatconversationaisetting.exception.ChatAiSettingsNotFoundApplicationException;
import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;

public class UpdateChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public UpdateChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public ChatAiSettingsResponse execute(UpdateChatAiSettingsCommand command) {
        ChatAiSettings aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiSettingsNotFoundApplicationException(command.id()));
        aggregate.update(command.conversationId(), command.aiEnabled(), command.defaultModelId());
        ChatAiSettings saved = repository.save(aggregate);
        return ChatAiSettingsResponse.fromDomain(saved);
    }
}
