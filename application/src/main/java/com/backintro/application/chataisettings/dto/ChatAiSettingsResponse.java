package com.backintro.application.chataisettings.dto;

import java.util.UUID;
import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;

public record ChatAiSettingsResponse(UUID id, String name, String code, boolean active) {
    public static ChatAiSettingsResponse fromDomain(ChatAiSettings aggregate) {
        return new ChatAiSettingsResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
