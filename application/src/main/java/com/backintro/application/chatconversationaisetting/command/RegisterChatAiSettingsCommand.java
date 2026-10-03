package com.backintro.application.chatconversationaisetting.command;

import java.util.UUID;

public record RegisterChatAiSettingsCommand(UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
}
