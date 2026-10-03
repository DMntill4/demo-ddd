package com.backintro.application.chatconversationaisetting.command;

import java.util.UUID;

import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;

public record UpdateChatAiSettingsCommand(ChatAiSettingsId id, UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
}
