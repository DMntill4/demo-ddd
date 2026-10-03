package com.backintro.domain.patientallergy.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patientallergy.event.PatientAllergyRegisteredEvent;
import com.backintro.domain.patientallergy.event.PatientAllergyUpdatedEvent;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public class PatientAllergy extends AggregateRoot {
    private final PatientAllergyId id;
    private UUID patientId;
    private String substance;
    private String reaction;
    private String severity;
    private boolean active;
    private LocalDateTime recordedAt;
    private UUID recordedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private PatientAllergy(
            PatientAllergyId id, UUID patientId, String substance, String reaction, String severity, boolean active, LocalDateTime recordedAt, UUID recordedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = patientId;
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static PatientAllergy register(UUID patientId, String substance, String reaction, String severity, LocalDateTime recordedAt, UUID recordedBy) {
        PatientAllergyId id = PatientAllergyId.generate();
        LocalDateTime now = LocalDateTime.now();
        PatientAllergy aggregate = new PatientAllergy(id, patientId, substance, reaction, severity, true, recordedAt, recordedBy, now, now);
        aggregate.recordEvent(new PatientAllergyRegisteredEvent(id, now));
        return aggregate;
    }

    public static PatientAllergy restore(
            PatientAllergyId id, UUID patientId, String substance, String reaction, String severity, boolean active, LocalDateTime recordedAt, UUID recordedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new PatientAllergy(id, patientId, substance, reaction, severity, active, recordedAt, recordedBy, createdAt, updatedAt);
    }

    public void update(UUID patientId, String substance, String reaction, String severity, LocalDateTime recordedAt, UUID recordedBy) {
        this.patientId = patientId;
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PatientAllergyUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public PatientAllergyId id() { return id; }
    public UUID patientId() { return patientId; }
    public String substance() { return substance; }
    public String reaction() { return reaction; }
    public String severity() { return severity; }
    public boolean active() { return active; }
    public LocalDateTime recordedAt() { return recordedAt; }
    public UUID recordedBy() { return recordedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
