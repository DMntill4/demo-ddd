package com.backintro.domain.chatescalation.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public record ChatEscalationDeletedEvent(
        ChatEscalationId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
