package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.dto.ChatAiSettingsResponse;
import com.backintro.application.chatconversationaisetting.exception.ChatAiSettingsNotFoundApplicationException;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;

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
