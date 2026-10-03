package com.backintro.domain.diagnosticsystem.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.diagnosticsystem.event.DiagnosticSystemRegisteredEvent;
import com.backintro.domain.diagnosticsystem.event.DiagnosticSystemUpdatedEvent;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public class DiagnosticSystem extends AggregateRoot {
    private final DiagnosticSystemId id;
    private String code;
    private String name;
    private boolean active;
    private String version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DiagnosticSystem(
            DiagnosticSystemId id, String code, String name, boolean active, String version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static DiagnosticSystem register(String code, String name, String version) {
        DiagnosticSystemId id = DiagnosticSystemId.generate();
        LocalDateTime now = LocalDateTime.now();
        DiagnosticSystem aggregate = new DiagnosticSystem(id, code, name, true, version, now, now);
        aggregate.recordEvent(new DiagnosticSystemRegisteredEvent(id, now));
        return aggregate;
    }

    public static DiagnosticSystem restore(
            DiagnosticSystemId id, String code, String name, boolean active, String version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new DiagnosticSystem(id, code, name, active, version, createdAt, updatedAt);
    }

    public void update(String code, String name, String version) {
        this.code = code;
        this.name = name;
        this.version = version;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new DiagnosticSystemUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public DiagnosticSystemId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String version() { return version; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
