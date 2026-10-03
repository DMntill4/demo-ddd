package com.backintro.infrastructure.chatairun.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateChatAiRunRequest(UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
}
