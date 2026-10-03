package com.backintro.domain.treatmentplan.model.aggregate;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentplan.event.TreatmentPlanRegisteredEvent;
import com.backintro.domain.treatmentplan.event.TreatmentPlanUpdatedEvent;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public class TreatmentPlan extends AggregateRoot {
    private final TreatmentPlanId id;
    private UUID encounterId;
    private UUID professionalId;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID treatmentStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentPlan(
            TreatmentPlanId id, UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = encounterId;
        this.professionalId = professionalId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = treatmentStatusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TreatmentPlan register(UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId) {
        TreatmentPlanId id = TreatmentPlanId.generate();
        LocalDateTime now = LocalDateTime.now();
        TreatmentPlan aggregate = new TreatmentPlan(id, encounterId, professionalId, title, description, startDate, endDate, treatmentStatusId, now, now);
        aggregate.recordEvent(new TreatmentPlanRegisteredEvent(id, now));
        return aggregate;
    }

    public static TreatmentPlan restore(
            TreatmentPlanId id, UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentPlan(id, encounterId, professionalId, title, description, startDate, endDate, treatmentStatusId, createdAt, updatedAt);
    }

    public void update(UUID encounterId, UUID professionalId, String title, String description, LocalDate startDate, LocalDate endDate, UUID treatmentStatusId) {
        this.encounterId = encounterId;
        this.professionalId = professionalId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = treatmentStatusId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentPlanUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentPlanId id() { return id; }
    public UUID encounterId() { return encounterId; }
    public UUID professionalId() { return professionalId; }
    public String title() { return title; }
    public String description() { return description; }
    public LocalDate startDate() { return startDate; }
    public LocalDate endDate() { return endDate; }
    public UUID treatmentStatusId() { return treatmentStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
