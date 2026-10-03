package com.backintro.domain.conversationsstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.conversationsstatus.event.ConversationStatusRegisteredEvent;
import com.backintro.domain.conversationsstatus.event.ConversationStatusUpdatedEvent;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;

public class ConversationStatus extends AggregateRoot {
    private final ConversationStatusId id;
    private String nameStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ConversationStatus(
            ConversationStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = nameStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ConversationStatus register(String nameStatus) {
        ConversationStatusId id = ConversationStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        ConversationStatus aggregate = new ConversationStatus(id, nameStatus, now, now);
        aggregate.recordEvent(new ConversationStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static ConversationStatus restore(
            ConversationStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ConversationStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = nameStatus;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ConversationStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ConversationStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
