package com.backintro.domain.conversationstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.conversationstatus.event.ConversationStatusRegisteredEvent;
import com.backintro.domain.conversationstatus.event.ConversationStatusUpdatedEvent;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;

public class ConversationStatus extends AggregateRoot {
    private final ConversationStatusId id;
    private String name;
    private String code;
    private boolean active;

    private ConversationStatus(
            ConversationStatusId id,
            String name,
            String code,
            boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static ConversationStatus register(
            String name,
            String code) {
        ConversationStatusId id = ConversationStatusId.generate();
        ConversationStatus aggregate = new ConversationStatus(id, name, code, true);
        aggregate.recordEvent(new ConversationStatusRegisteredEvent(id, LocalDateTime.now()));
        return aggregate;
    }

    public static ConversationStatus restore(
            ConversationStatusId id,
            String name,
            String code,
            boolean active) {
        return new ConversationStatus(id, name, code, active);
    }

    public void update(
            String name,
            String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new ConversationStatusUpdatedEvent(this.id, this.name, this.code, LocalDateTime.now()));
    }

    public ConversationStatusId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}
