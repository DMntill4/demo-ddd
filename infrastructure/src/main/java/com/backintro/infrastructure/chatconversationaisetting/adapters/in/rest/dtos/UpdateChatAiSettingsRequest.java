package com.backintro.infrastructure.chatconversationaisetting.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatAiSettingsRequest(UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
}
