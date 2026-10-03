package com.backintro.domain.chatconversation.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatconversation.event.ChatConversationRegisteredEvent;
import com.backintro.domain.chatconversation.event.ChatConversationUpdatedEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public class ChatConversation extends AggregateRoot {
    private final ChatConversationId id;
    private UUID conversationStatusId;
    private UUID priorityId;
    private LocalDateTime lastMessageAt;
    private boolean closed;
    private LocalDateTime closedAt;
    private UUID closedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatConversation(
            ChatConversationId id, UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationStatusId = conversationStatusId;
        this.priorityId = priorityId;
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ChatConversation register(UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy) {
        ChatConversationId id = ChatConversationId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatConversation aggregate = new ChatConversation(id, conversationStatusId, priorityId, lastMessageAt, closed, closedAt, closedBy, now, now);
        aggregate.recordEvent(new ChatConversationRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatConversation restore(
            ChatConversationId id, UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatConversation(id, conversationStatusId, priorityId, lastMessageAt, closed, closedAt, closedBy, createdAt, updatedAt);
    }

    public void update(UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy) {
        this.conversationStatusId = conversationStatusId;
        this.priorityId = priorityId;
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatConversationUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatConversationId id() { return id; }
    public UUID conversationStatusId() { return conversationStatusId; }
    public UUID priorityId() { return priorityId; }
    public LocalDateTime lastMessageAt() { return lastMessageAt; }
    public boolean closed() { return closed; }
    public LocalDateTime closedAt() { return closedAt; }
    public UUID closedBy() { return closedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
