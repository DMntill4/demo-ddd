package com.backintro.application.chatconversationaisetting.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;

public record ChatAiSettingsResponse(UUID id, UUID conversationId, boolean aiEnabled, UUID defaultModelId, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static ChatAiSettingsResponse fromDomain(ChatAiSettings aggregate) {
        return new ChatAiSettingsResponse(aggregate.id().value(), aggregate.conversationId(), aggregate.aiEnabled(), aggregate.defaultModelId(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
