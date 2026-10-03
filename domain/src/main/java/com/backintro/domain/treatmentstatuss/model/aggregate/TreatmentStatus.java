package com.backintro.domain.treatmentstatuss.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentstatuss.event.TreatmentStatusRegisteredEvent;
import com.backintro.domain.treatmentstatuss.event.TreatmentStatusUpdatedEvent;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public class TreatmentStatus extends AggregateRoot {
    private final TreatmentStatusId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentStatus(
            TreatmentStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TreatmentStatus register(String code, String name) {
        TreatmentStatusId id = TreatmentStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        TreatmentStatus aggregate = new TreatmentStatus(id, code, name, true, now, now);
        aggregate.recordEvent(new TreatmentStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static TreatmentStatus restore(
            TreatmentStatusId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
