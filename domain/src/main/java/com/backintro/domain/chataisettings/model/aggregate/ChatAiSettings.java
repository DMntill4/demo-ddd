package com.backintro.domain.chataisettings.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chataisettings.event.ChatAiSettingsRegisteredEvent;
import com.backintro.domain.chataisettings.event.ChatAiSettingsUpdatedEvent;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;

public class ChatAiSettings extends AggregateRoot {
    private final ChatAiSettingsId id;
    private String name;
    private String code;
    private boolean active;

    private ChatAiSettings(
            ChatAiSettingsId id,
            String name,
            String code,
            boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static ChatAiSettings register(
            String name,
            String code) {
        ChatAiSettingsId id = ChatAiSettingsId.generate();
        ChatAiSettings aggregate = new ChatAiSettings(id, name, code, true);
        aggregate.recordEvent(new ChatAiSettingsRegisteredEvent(id, LocalDateTime.now()));
        return aggregate;
    }

    public static ChatAiSettings restore(
            ChatAiSettingsId id,
            String name,
            String code,
            boolean active) {
        return new ChatAiSettings(id, name, code, active);
    }

    public void update(
            String name,
            String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new ChatAiSettingsUpdatedEvent(this.id, this.name, this.code, LocalDateTime.now()));
    }

    public ChatAiSettingsId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}
