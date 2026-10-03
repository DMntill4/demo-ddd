package com.backintro.domain.gender.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.gender.event.GenderRegisteredEvent;
import com.backintro.domain.gender.event.GenderUpdatedEvent;
import com.backintro.domain.gender.model.valueobject.GenderId;

public class Gender extends AggregateRoot {
    private final GenderId id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Gender(
            GenderId id, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Gender register(String description) {
        GenderId id = GenderId.generate();
        LocalDateTime now = LocalDateTime.now();
        Gender aggregate = new Gender(id, description, now, now);
        aggregate.recordEvent(new GenderRegisteredEvent(id, now));
        return aggregate;
    }

    public static Gender restore(
            GenderId id, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Gender(id, description, createdAt, updatedAt);
    }

    public void update(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new GenderUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public GenderId id() { return id; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
