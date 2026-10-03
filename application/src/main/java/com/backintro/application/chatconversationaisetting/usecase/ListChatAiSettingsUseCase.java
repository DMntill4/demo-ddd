package com.backintro.application.chatconversationaisetting.usecase;

import java.util.List;
import com.backintro.application.chatconversationaisetting.dto.ChatAiSettingsResponse;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;

public class ListChatAiSettingsUseCase {
    private final ChatAiSettingsRepository repository;

    public ListChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        this.repository = repository;
    }

    public List<ChatAiSettingsResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ChatAiSettingsResponse::fromDomain)
                .toList();
    }
}
