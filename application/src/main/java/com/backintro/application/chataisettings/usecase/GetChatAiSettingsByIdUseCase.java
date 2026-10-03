package com.backintro.application.chataisettings.usecase;

import com.backintro.application.chataisettings.dto.ChatAiSettingsResponse;
import com.backintro.application.chataisettings.exception.ChatAiSettingsNotFoundApplicationException;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;

public class GetChatAiSettingsByIdUseCase {
    private final ChatAiSettingsRepository repository;

    public GetChatAiSettingsByIdUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public ChatAiSettingsResponse execute(ChatAiSettingsId id) {
        return repository.findById(id)
                .map(ChatAiSettingsResponse::fromDomain)
                .orElseThrow(() -> new ChatAiSettingsNotFoundApplicationException(id));
    }
}
