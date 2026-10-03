package com.backintro.domain.chatescalationstatushistory.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryRegisteredEvent;
import com.backintro.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryUpdatedEvent;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public class ChatEscalationStatusHistory extends AggregateRoot {
    private final ChatEscalationStatusHistoryId id;
    private UUID escalationId;
    private UUID escalationStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime changedAt;

    private ChatEscalationStatusHistory(
            ChatEscalationStatusHistoryId id, UUID escalationId, UUID escalationStatusId, LocalDateTime createdAt, LocalDateTime changedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = escalationId;
        this.escalationStatusId = escalationStatusId;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
    }

    public static ChatEscalationStatusHistory register(UUID escalationId, UUID escalationStatusId, LocalDateTime changedAt) {
        ChatEscalationStatusHistoryId id = ChatEscalationStatusHistoryId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatEscalationStatusHistory aggregate = new ChatEscalationStatusHistory(id, escalationId, escalationStatusId, now, changedAt);
        aggregate.recordEvent(new ChatEscalationStatusHistoryRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatEscalationStatusHistory restore(
            ChatEscalationStatusHistoryId id, UUID escalationId, UUID escalationStatusId, LocalDateTime createdAt, LocalDateTime changedAt) {
        return new ChatEscalationStatusHistory(id, escalationId, escalationStatusId, createdAt, changedAt);
    }

    public void update(UUID escalationId, UUID escalationStatusId, LocalDateTime changedAt) {
        this.escalationId = escalationId;
        this.escalationStatusId = escalationStatusId;
        this.changedAt = changedAt;
        recordEvent(new ChatEscalationStatusHistoryUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatEscalationStatusHistoryId id() { return id; }
    public UUID escalationId() { return escalationId; }
    public UUID escalationStatusId() { return escalationStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime changedAt() { return changedAt; }
}
