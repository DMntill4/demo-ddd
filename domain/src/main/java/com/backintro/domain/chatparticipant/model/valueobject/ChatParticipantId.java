package com.backintro.domain.chatparticipant.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatParticipantId(UUID value) {
    public ChatParticipantId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static ChatParticipantId generate() {
        return new ChatParticipantId(UUID.randomUUID());
    }
}
