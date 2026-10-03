package com.backintro.domain.messagetype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.messagetype.event.MessageTypeRegisteredEvent;
import com.backintro.domain.messagetype.event.MessageTypeUpdatedEvent;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public class MessageType extends AggregateRoot {
    private final MessageTypeId id;
    private String nameType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private MessageType(
            MessageTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameType = nameType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static MessageType register(String nameType) {
        MessageTypeId id = MessageTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        MessageType aggregate = new MessageType(id, nameType, now, now);
        aggregate.recordEvent(new MessageTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static MessageType restore(
            MessageTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new MessageType(id, nameType, createdAt, updatedAt);
    }

    public void update(String nameType) {
        this.nameType = nameType;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new MessageTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public MessageTypeId id() { return id; }
    public String nameType() { return nameType; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
