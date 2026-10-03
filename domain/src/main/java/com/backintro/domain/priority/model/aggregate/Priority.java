package com.backintro.domain.priority.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.priority.event.PriorityRegisteredEvent;
import com.backintro.domain.priority.event.PriorityUpdatedEvent;
import com.backintro.domain.priority.model.valueobject.PriorityId;

public class Priority extends AggregateRoot {
    private final PriorityId id;
    private String namePriority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Priority(
            PriorityId id, String namePriority, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.namePriority = namePriority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Priority register(String namePriority) {
        PriorityId id = PriorityId.generate();
        LocalDateTime now = LocalDateTime.now();
        Priority aggregate = new Priority(id, namePriority, now, now);
        aggregate.recordEvent(new PriorityRegisteredEvent(id, now));
        return aggregate;
    }

    public static Priority restore(
            PriorityId id, String namePriority, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Priority(id, namePriority, createdAt, updatedAt);
    }

    public void update(String namePriority) {
        this.namePriority = namePriority;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PriorityUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public PriorityId id() { return id; }
    public String namePriority() { return namePriority; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
