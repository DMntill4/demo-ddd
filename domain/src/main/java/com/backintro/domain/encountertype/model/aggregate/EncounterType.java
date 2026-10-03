package com.backintro.domain.encountertype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encountertype.event.EncounterTypeRegisteredEvent;
import com.backintro.domain.encountertype.event.EncounterTypeUpdatedEvent;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public class EncounterType extends AggregateRoot {
    private final EncounterTypeId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterType(
            EncounterTypeId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EncounterType register(String code, String name) {
        EncounterTypeId id = EncounterTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        EncounterType aggregate = new EncounterType(id, code, name, true, now, now);
        aggregate.recordEvent(new EncounterTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static EncounterType restore(
            EncounterTypeId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterType(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EncounterTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
