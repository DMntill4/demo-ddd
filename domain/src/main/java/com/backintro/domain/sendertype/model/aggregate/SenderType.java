package com.backintro.domain.sendertype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.sendertype.event.SenderTypeRegisteredEvent;
import com.backintro.domain.sendertype.event.SenderTypeUpdatedEvent;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public class SenderType extends AggregateRoot {
    private final SenderTypeId id;
    private String nameType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private SenderType(
            SenderTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameType = nameType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static SenderType register(String nameType) {
        SenderTypeId id = SenderTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        SenderType aggregate = new SenderType(id, nameType, now, now);
        aggregate.recordEvent(new SenderTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static SenderType restore(
            SenderTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new SenderType(id, nameType, createdAt, updatedAt);
    }

    public void update(String nameType) {
        this.nameType = nameType;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new SenderTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public SenderTypeId id() { return id; }
    public String nameType() { return nameType; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
