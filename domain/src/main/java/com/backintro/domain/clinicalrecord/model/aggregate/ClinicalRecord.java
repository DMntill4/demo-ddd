package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalrecord.event.ClinicalRecordRegisteredEvent;
import com.backintro.domain.clinicalrecord.event.ClinicalRecordUpdatedEvent;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public class ClinicalRecord extends AggregateRoot {
    private final ClinicalRecordId id;
    private UUID patientId;
    private LocalDateTime creationDate;
    private String recordNumber;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private UUID statusId;
    private LocalDateTime createdAt;
    private UUID createdBy;

    private ClinicalRecord(
            ClinicalRecordId id, UUID patientId, LocalDateTime creationDate, String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt, UUID statusId, LocalDateTime createdAt, UUID createdBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = patientId;
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static ClinicalRecord register(UUID patientId, LocalDateTime creationDate, String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt, UUID statusId, UUID createdBy) {
        ClinicalRecordId id = ClinicalRecordId.generate();
        LocalDateTime now = LocalDateTime.now();
        ClinicalRecord aggregate = new ClinicalRecord(id, patientId, creationDate, recordNumber, openedAt, closedAt, statusId, now, createdBy);
        aggregate.recordEvent(new ClinicalRecordRegisteredEvent(id, now));
        return aggregate;
    }

    public static ClinicalRecord restore(
            ClinicalRecordId id, UUID patientId, LocalDateTime creationDate, String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt, UUID statusId, LocalDateTime createdAt, UUID createdBy) {
        return new ClinicalRecord(id, patientId, creationDate, recordNumber, openedAt, closedAt, statusId, createdAt, createdBy);
    }

    public void update(UUID patientId, LocalDateTime creationDate, String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt, UUID statusId, UUID createdBy) {
        this.patientId = patientId;
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = statusId;
        this.createdBy = createdBy;
        recordEvent(new ClinicalRecordUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalRecordId id() { return id; }
    public UUID patientId() { return patientId; }
    public LocalDateTime creationDate() { return creationDate; }
    public String recordNumber() { return recordNumber; }
    public LocalDateTime openedAt() { return openedAt; }
    public LocalDateTime closedAt() { return closedAt; }
    public UUID statusId() { return statusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public UUID createdBy() { return createdBy; }
}
