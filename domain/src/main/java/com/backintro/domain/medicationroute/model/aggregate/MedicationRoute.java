package com.backintro.domain.medicationroute.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.medicationroute.event.MedicationRouteRegisteredEvent;
import com.backintro.domain.medicationroute.event.MedicationRouteUpdatedEvent;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public class MedicationRoute extends AggregateRoot {
    private final MedicationRouteId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private MedicationRoute(
            MedicationRouteId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static MedicationRoute register(String code, String name) {
        MedicationRouteId id = MedicationRouteId.generate();
        LocalDateTime now = LocalDateTime.now();
        MedicationRoute aggregate = new MedicationRoute(id, code, name, true, now, now);
        aggregate.recordEvent(new MedicationRouteRegisteredEvent(id, now));
        return aggregate;
    }

    public static MedicationRoute restore(
            MedicationRouteId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new MedicationRoute(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new MedicationRouteUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public MedicationRouteId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
