package com.backintro.domain.encountermodality.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encountermodality.event.EncounterModalityRegisteredEvent;
import com.backintro.domain.encountermodality.event.EncounterModalityUpdatedEvent;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public class EncounterModality extends AggregateRoot {
    private final EncounterModalityId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterModality(
            EncounterModalityId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EncounterModality register(String code, String name) {
        EncounterModalityId id = EncounterModalityId.generate();
        LocalDateTime now = LocalDateTime.now();
        EncounterModality aggregate = new EncounterModality(id, code, name, true, now, now);
        aggregate.recordEvent(new EncounterModalityRegisteredEvent(id, now));
        return aggregate;
    }

    public static EncounterModality restore(
            EncounterModalityId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterModality(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EncounterModalityUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterModalityId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
