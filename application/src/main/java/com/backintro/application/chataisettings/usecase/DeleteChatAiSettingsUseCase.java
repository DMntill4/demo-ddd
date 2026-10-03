package com.backintro.application.chataisettings.usecase;

import com.backintro.application.chataisettings.exception.ChatAiSettingsNotFoundApplicationException;
import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;

public class DeleteChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public DeleteChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatAiSettingsId id) {
        ChatAiSettings aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatAiSettingsNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
