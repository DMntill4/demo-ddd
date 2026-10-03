package com.backintro.domain.escalationsstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.escalationsstatus.event.EscalationStatusRegisteredEvent;
import com.backintro.domain.escalationsstatus.event.EscalationStatusUpdatedEvent;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public class EscalationStatus extends AggregateRoot {
    private final EscalationStatusId id;
    private String nameStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EscalationStatus(
            EscalationStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = nameStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EscalationStatus register(String nameStatus) {
        EscalationStatusId id = EscalationStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        EscalationStatus aggregate = new EscalationStatus(id, nameStatus, now, now);
        aggregate.recordEvent(new EscalationStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static EscalationStatus restore(
            EscalationStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EscalationStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = nameStatus;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EscalationStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EscalationStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
