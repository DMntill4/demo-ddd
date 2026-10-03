package com.backintro.domain.treatmentgoalstatuss.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentgoalstatuss.event.TreatmentGoalStatusRegisteredEvent;
import com.backintro.domain.treatmentgoalstatuss.event.TreatmentGoalStatusUpdatedEvent;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;

public class TreatmentGoalStatus extends AggregateRoot {
    private final TreatmentGoalStatusId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoalStatus(
            TreatmentGoalStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoalStatus register(String code, String name) {
        TreatmentGoalStatusId id = TreatmentGoalStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        TreatmentGoalStatus aggregate = new TreatmentGoalStatus(id, code, name, true, now, now);
        aggregate.recordEvent(new TreatmentGoalStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static TreatmentGoalStatus restore(
            TreatmentGoalStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentGoalStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentGoalStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentGoalStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
