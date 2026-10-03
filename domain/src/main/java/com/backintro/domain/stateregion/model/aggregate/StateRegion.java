package com.backintro.domain.stateregion.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.stateregion.event.StateRegionRegisteredEvent;
import com.backintro.domain.stateregion.event.StateRegionUpdatedEvent;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public class StateRegion extends AggregateRoot {
    private final StateRegionId id;
    private String nameRegion;
    private String codeRegion;
    private String description;
    private boolean isActive;
    private UUID countryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private StateRegion(
            StateRegionId id, String nameRegion, String codeRegion, String description, boolean isActive, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameRegion = nameRegion;
        this.codeRegion = codeRegion;
        this.description = description;
        this.isActive = isActive;
        this.countryId = countryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static StateRegion register(String nameRegion, String codeRegion, String description, UUID countryId) {
        StateRegionId id = StateRegionId.generate();
        LocalDateTime now = LocalDateTime.now();
        StateRegion aggregate = new StateRegion(id, nameRegion, codeRegion, description, true, countryId, now, now);
        aggregate.recordEvent(new StateRegionRegisteredEvent(id, now));
        return aggregate;
    }

    public static StateRegion restore(
            StateRegionId id, String nameRegion, String codeRegion, String description, boolean isActive, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new StateRegion(id, nameRegion, codeRegion, description, isActive, countryId, createdAt, updatedAt);
    }

    public void update(String nameRegion, String codeRegion, String description, UUID countryId) {
        this.nameRegion = nameRegion;
        this.codeRegion = codeRegion;
        this.description = description;
        this.countryId = countryId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new StateRegionUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public StateRegionId id() { return id; }
    public String nameRegion() { return nameRegion; }
    public String codeRegion() { return codeRegion; }
    public String description() { return description; }
    public boolean isActive() { return isActive; }
    public UUID countryId() { return countryId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
