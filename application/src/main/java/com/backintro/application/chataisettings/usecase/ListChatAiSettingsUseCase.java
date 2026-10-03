package com.backintro.application.chataisettings.usecase;

import java.util.List;
import com.backintro.application.chataisettings.dto.ChatAiSettingsResponse;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;

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
