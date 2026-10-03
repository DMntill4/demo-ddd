package com.backintro.domain.risklevel.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.risklevel.event.RiskLevelRegisteredEvent;
import com.backintro.domain.risklevel.event.RiskLevelUpdatedEvent;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public class RiskLevel extends AggregateRoot {
    private final RiskLevelId id;
    private String code;
    private String name;
    private boolean active;
    private Integer severity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private RiskLevel(
            RiskLevelId id, String code, String name, boolean active, Integer severity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.severity = severity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static RiskLevel register(String code, String name, Integer severity) {
        RiskLevelId id = RiskLevelId.generate();
        LocalDateTime now = LocalDateTime.now();
        RiskLevel aggregate = new RiskLevel(id, code, name, true, severity, now, now);
        aggregate.recordEvent(new RiskLevelRegisteredEvent(id, now));
        return aggregate;
    }

    public static RiskLevel restore(
            RiskLevelId id, String code, String name, boolean active, Integer severity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new RiskLevel(id, code, name, active, severity, createdAt, updatedAt);
    }

    public void update(String code, String name, Integer severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new RiskLevelUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public RiskLevelId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public Integer severity() { return severity; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
