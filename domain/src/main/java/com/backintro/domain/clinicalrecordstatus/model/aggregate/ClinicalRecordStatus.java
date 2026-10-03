package com.backintro.domain.clinicalrecordstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalrecordstatus.event.ClinicalRecordStatusRegisteredEvent;
import com.backintro.domain.clinicalrecordstatus.event.ClinicalRecordStatusUpdatedEvent;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public class ClinicalRecordStatus extends AggregateRoot {
    private final ClinicalRecordStatusId id;
    private String code;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalRecordStatus(
            ClinicalRecordStatusId id, String code, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ClinicalRecordStatus register(String code, String name) {
        ClinicalRecordStatusId id = ClinicalRecordStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        ClinicalRecordStatus aggregate = new ClinicalRecordStatus(id, code, name, now, now);
        aggregate.recordEvent(new ClinicalRecordStatusRegisteredEvent(id, now));
        return aggregate;
    }

    public static ClinicalRecordStatus restore(
            ClinicalRecordStatusId id, String code, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ClinicalRecordStatus(id, code, name, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ClinicalRecordStatusUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalRecordStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
