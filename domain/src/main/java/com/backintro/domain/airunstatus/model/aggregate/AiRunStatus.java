package com.backintro.domain.airunstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.airunstatus.event.AiRunStatusRegisteredEvent;
import com.backintro.domain.airunstatus.event.AiRunStatusUpdatedEvent;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;

public class AiRunStatus extends AggregateRoot {
    private final AiRunStatusId id;
    private String name;
    private String code;
    private boolean active;

    private AiRunStatus(
            AiRunStatusId id,
            String name,
            String code,
            boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static AiRunStatus register(
            String name,
            String code) {
        AiRunStatusId id = AiRunStatusId.generate();
        AiRunStatus aggregate = new AiRunStatus(id, name, code, true);
        aggregate.recordEvent(new AiRunStatusRegisteredEvent(id, LocalDateTime.now()));
        return aggregate;
    }

    public static AiRunStatus restore(
            AiRunStatusId id,
            String name,
            String code,
            boolean active) {
        return new AiRunStatus(id, name, code, active);
    }

    public void update(
            String name,
            String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new AiRunStatusUpdatedEvent(this.id, this.name, this.code, LocalDateTime.now()));
    }

    public AiRunStatusId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}
