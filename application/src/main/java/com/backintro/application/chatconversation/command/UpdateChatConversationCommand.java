package com.backintro.application.chatconversation.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public record UpdateChatConversationCommand(ChatConversationId id, UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy) {
}
