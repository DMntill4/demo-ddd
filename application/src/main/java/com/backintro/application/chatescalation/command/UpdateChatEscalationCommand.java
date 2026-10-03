package com.backintro.application.chatescalation.command;

import java.util.UUID;

import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public record UpdateChatEscalationCommand(ChatEscalationId id, UUID conversationId, UUID statusId, boolean fromAi, String reason) {
}
