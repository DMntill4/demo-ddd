package com.backintro.application.chatescalation.command;

import java.util.UUID;

public record RegisterChatEscalationCommand(UUID conversationId, UUID statusId, boolean fromAi, String reason) {
}
