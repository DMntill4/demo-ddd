package com.backintro.domain.airunsstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.airunsstatus.event.AiRunStatusRegisteredEvent;
import com.backintro.domain.airunsstatus.event.AiRunStatusUpdatedEvent;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public class AiRunStatus extends AggregateRoot {
    private final AiRunStatusId id;
    private String nameStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiRunStatus(
            AiRunStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = nameStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AiRunStatus register(String nameStatus) {
        AiRunStatusId id = AiRunStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        AiRunStatus aggregate = new AiRunStatus(id, nameStatus, now, now);
        aggregate.recordEvent(new AiRunStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static AiRunStatus restore(
            AiRunStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AiRunStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = nameStatus;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AiRunStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public AiRunStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
