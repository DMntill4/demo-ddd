package com.backintro.application.chatmessage.command;

import java.util.UUID;

import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public record UpdateChatMessageCommand(ChatMessageId id, UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata) {
}
