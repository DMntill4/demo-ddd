package com.backintro.infrastructure.chatairun.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatAiRunRequest(UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
}
