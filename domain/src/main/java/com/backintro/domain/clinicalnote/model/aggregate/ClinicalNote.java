package com.backintro.domain.clinicalnote.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalnote.event.ClinicalNoteRegisteredEvent;
import com.backintro.domain.clinicalnote.event.ClinicalNoteUpdatedEvent;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public class ClinicalNote extends AggregateRoot {
    private final ClinicalNoteId id;
    private UUID encounterId;
    private UUID professionalId;
    private String subjective;
    private String objective;
    private String assessment;
    private String plan;
    private String additionalNotes;
    private LocalDateTime signedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalNote(
            ClinicalNoteId id, UUID encounterId, UUID professionalId, String subjective, String objective, String assessment, String plan, String additionalNotes, LocalDateTime signedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = encounterId;
        this.professionalId = professionalId;
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ClinicalNote register(UUID encounterId, UUID professionalId, String subjective, String objective, String assessment, String plan, String additionalNotes, LocalDateTime signedAt) {
        ClinicalNoteId id = ClinicalNoteId.generate();
        LocalDateTime now = LocalDateTime.now();
        ClinicalNote aggregate = new ClinicalNote(id, encounterId, professionalId, subjective, objective, assessment, plan, additionalNotes, signedAt, now, now);
        aggregate.recordEvent(new ClinicalNoteRegisteredEvent(id, now));
        return aggregate;
    }

    public static ClinicalNote restore(
            ClinicalNoteId id, UUID encounterId, UUID professionalId, String subjective, String objective, String assessment, String plan, String additionalNotes, LocalDateTime signedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ClinicalNote(id, encounterId, professionalId, subjective, objective, assessment, plan, additionalNotes, signedAt, createdAt, updatedAt);
    }

    public void update(UUID encounterId, UUID professionalId, String subjective, String objective, String assessment, String plan, String additionalNotes, LocalDateTime signedAt) {
        this.encounterId = encounterId;
        this.professionalId = professionalId;
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ClinicalNoteUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalNoteId id() { return id; }
    public UUID encounterId() { return encounterId; }
    public UUID professionalId() { return professionalId; }
    public String subjective() { return subjective; }
    public String objective() { return objective; }
    public String assessment() { return assessment; }
    public String plan() { return plan; }
    public String additionalNotes() { return additionalNotes; }
    public LocalDateTime signedAt() { return signedAt; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
