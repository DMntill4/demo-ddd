package com.backintro.domain.escalationsstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public record EscalationStatusUpdatedEvent(
        EscalationStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
