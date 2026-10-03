package com.backintro.domain.chataisettings.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatAiSettingsId(UUID value) {
    public ChatAiSettingsId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static ChatAiSettingsId generate() {
        return new ChatAiSettingsId(UUID.randomUUID());
    }
}
