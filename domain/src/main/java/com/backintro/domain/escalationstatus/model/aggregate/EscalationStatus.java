package com.backintro.domain.escalationstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.escalationstatus.event.EscalationStatusRegisteredEvent;
import com.backintro.domain.escalationstatus.event.EscalationStatusUpdatedEvent;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public class EscalationStatus extends AggregateRoot {
    private final EscalationStatusId id;
    private String name;
    private String code;
    private boolean active;

    private EscalationStatus(
            EscalationStatusId id,
            String name,
            String code,
            boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static EscalationStatus register(
            String name,
            String code) {
        EscalationStatusId id = EscalationStatusId.generate();
        EscalationStatus aggregate = new EscalationStatus(id, name, code, true);
        aggregate.recordEvent(new EscalationStatusRegisteredEvent(id, LocalDateTime.now()));
        return aggregate;
    }

    public static EscalationStatus restore(
            EscalationStatusId id,
            String name,
            String code,
            boolean active) {
        return new EscalationStatus(id, name, code, active);
    }

    public void update(
            String name,
            String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new EscalationStatusUpdatedEvent(this.id, this.name, this.code, LocalDateTime.now()));
    }

    public EscalationStatusId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}
