package com.backintro.application.chataisettings.usecase;

import com.backintro.application.chataisettings.command.UpdateChatAiSettingsCommand;
import com.backintro.application.chataisettings.dto.ChatAiSettingsResponse;
import com.backintro.application.chataisettings.exception.ChatAiSettingsNotFoundApplicationException;
import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;

public class UpdateChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public UpdateChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public ChatAiSettingsResponse execute(UpdateChatAiSettingsCommand command) {
        ChatAiSettings aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiSettingsNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        ChatAiSettings saved = repository.save(aggregate);
        return ChatAiSettingsResponse.fromDomain(saved);
    }
}
