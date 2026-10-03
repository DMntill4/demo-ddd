package com.backintro.domain.treatmentgoal.model.aggregate;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentgoal.event.TreatmentGoalRegisteredEvent;
import com.backintro.domain.treatmentgoal.event.TreatmentGoalUpdatedEvent;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public class TreatmentGoal extends AggregateRoot {
    private final TreatmentGoalId id;
    private UUID treatmentPlanId;
    private String description;
    private LocalDate targetDate;
    private LocalDateTime completedAt;
    private String notes;
    private UUID treatmentGoalStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoal(
            TreatmentGoalId id, UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.treatmentPlanId = treatmentPlanId;
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalStatusId = treatmentGoalStatusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoal register(UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId) {
        TreatmentGoalId id = TreatmentGoalId.generate();
        LocalDateTime now = LocalDateTime.now();
        TreatmentGoal aggregate = new TreatmentGoal(id, treatmentPlanId, description, targetDate, completedAt, notes, treatmentGoalStatusId, now, now);
        aggregate.recordEvent(new TreatmentGoalRegisteredEvent(id, now));
        return aggregate;
    }

    public static TreatmentGoal restore(
            TreatmentGoalId id, UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentGoal(id, treatmentPlanId, description, targetDate, completedAt, notes, treatmentGoalStatusId, createdAt, updatedAt);
    }

    public void update(UUID treatmentPlanId, String description, LocalDate targetDate, LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId) {
        this.treatmentPlanId = treatmentPlanId;
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalStatusId = treatmentGoalStatusId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentGoalUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentGoalId id() { return id; }
    public UUID treatmentPlanId() { return treatmentPlanId; }
    public String description() { return description; }
    public LocalDate targetDate() { return targetDate; }
    public LocalDateTime completedAt() { return completedAt; }
    public String notes() { return notes; }
    public UUID treatmentGoalStatusId() { return treatmentGoalStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
