package com.backintro.domain.assessmenttype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.assessmenttype.event.AssessmentTypeRegisteredEvent;
import com.backintro.domain.assessmenttype.event.AssessmentTypeUpdatedEvent;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public class AssessmentType extends AggregateRoot {
    private final AssessmentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AssessmentType(
            AssessmentTypeId id, String code, String name, boolean active, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AssessmentType register(String code, String name, String description) {
        AssessmentTypeId id = AssessmentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        AssessmentType aggregate = new AssessmentType(id, code, name, true, description, now, now);
        aggregate.recordEvent(new AssessmentTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static AssessmentType restore(
            AssessmentTypeId id, String code, String name, boolean active, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AssessmentType(id, code, name, active, description, createdAt, updatedAt);
    }

    public void update(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AssessmentTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public AssessmentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
