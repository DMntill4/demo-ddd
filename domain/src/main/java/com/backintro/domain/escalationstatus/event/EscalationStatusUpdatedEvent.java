package com.backintro.domain.escalationstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public record EscalationStatusUpdatedEvent(
        EscalationStatusId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
