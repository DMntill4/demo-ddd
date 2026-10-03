package com.backintro.domain.study.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.study.event.StudyRegisteredEvent;
import com.backintro.domain.study.event.StudyUpdatedEvent;
import com.backintro.domain.study.model.valueobject.StudyId;

public class Study extends AggregateRoot {
    private final StudyId id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Study(
            StudyId id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Study register(String name) {
        StudyId id = StudyId.generate();
        LocalDateTime now = LocalDateTime.now();
        Study aggregate = new Study(id, name, now, now);
        aggregate.recordEvent(new StudyRegisteredEvent(id, now));
        return aggregate;
    }

    public static Study restore(
            StudyId id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Study(id, name, createdAt, updatedAt);
    }

    public void update(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new StudyUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public StudyId id() { return id; }
    public String name() { return name; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
