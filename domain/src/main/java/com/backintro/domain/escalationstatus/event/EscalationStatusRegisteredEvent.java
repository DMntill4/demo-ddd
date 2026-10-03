package com.backintro.domain.escalationstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public record EscalationStatusRegisteredEvent(
        EscalationStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
