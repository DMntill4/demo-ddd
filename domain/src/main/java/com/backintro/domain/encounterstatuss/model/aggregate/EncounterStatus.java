package com.backintro.domain.encounterstatuss.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encounterstatuss.event.EncounterStatusRegisteredEvent;
import com.backintro.domain.encounterstatuss.event.EncounterStatusUpdatedEvent;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;

public class EncounterStatus extends AggregateRoot {
    private final EncounterStatusId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterStatus(
            EncounterStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EncounterStatus register(String code, String name) {
        EncounterStatusId id = EncounterStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        EncounterStatus aggregate = new EncounterStatus(id, code, name, true, now, now);
        aggregate.recordEvent(new EncounterStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static EncounterStatus restore(
            EncounterStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EncounterStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
