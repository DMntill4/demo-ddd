package com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatEscalationRequest(UUID conversationId, UUID statusId, boolean fromAi, String reason) {
}
