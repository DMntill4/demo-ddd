package com.backintro.domain.chatparticipant.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public record ChatParticipantRegisteredEvent(
        ChatParticipantId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
