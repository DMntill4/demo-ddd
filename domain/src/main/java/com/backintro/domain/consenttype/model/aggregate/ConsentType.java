package com.backintro.domain.consenttype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.consenttype.event.ConsentTypeRegisteredEvent;
import com.backintro.domain.consenttype.event.ConsentTypeUpdatedEvent;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public class ConsentType extends AggregateRoot {
    private final ConsentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ConsentType(
            ConsentTypeId id, String code, String name, boolean active, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ConsentType register(String code, String name, String description) {
        ConsentTypeId id = ConsentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        ConsentType aggregate = new ConsentType(id, code, name, true, description, now, now);
        aggregate.recordEvent(new ConsentTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static ConsentType restore(
            ConsentTypeId id, String code, String name, boolean active, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ConsentType(id, code, name, active, description, createdAt, updatedAt);
    }

    public void update(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ConsentTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ConsentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
