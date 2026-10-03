package com.backintro.application.chatconversation.command;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterChatConversationCommand(UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy) {
}
