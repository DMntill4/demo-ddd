package com.backintro.domain.chatmessage.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatmessage.event.ChatMessageRegisteredEvent;
import com.backintro.domain.chatmessage.event.ChatMessageUpdatedEvent;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public class ChatMessage extends AggregateRoot {
    private final ChatMessageId id;
    private UUID conversationId;
    private UUID messageTypeId;
    private UUID participantId;
    private String content;
    private String metadata;
    private LocalDateTime createdAt;

    private ChatMessage(
            ChatMessageId id, UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = conversationId;
        this.messageTypeId = messageTypeId;
        this.participantId = participantId;
        this.content = content;
        this.metadata = metadata;
        this.createdAt = createdAt;
    }

    public static ChatMessage register(UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata) {
        ChatMessageId id = ChatMessageId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatMessage aggregate = new ChatMessage(id, conversationId, messageTypeId, participantId, content, metadata, now);
        aggregate.recordEvent(new ChatMessageRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatMessage restore(
            ChatMessageId id, UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata, LocalDateTime createdAt) {
        return new ChatMessage(id, conversationId, messageTypeId, participantId, content, metadata, createdAt);
    }

    public void update(UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata) {
        this.conversationId = conversationId;
        this.messageTypeId = messageTypeId;
        this.participantId = participantId;
        this.content = content;
        this.metadata = metadata;
        recordEvent(new ChatMessageUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatMessageId id() { return id; }
    public UUID conversationId() { return conversationId; }
    public UUID messageTypeId() { return messageTypeId; }
    public UUID participantId() { return participantId; }
    public String content() { return content; }
    public String metadata() { return metadata; }
    public LocalDateTime createdAt() { return createdAt; }
}
