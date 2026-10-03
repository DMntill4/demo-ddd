package com.backintro.domain.priority.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.priority.model.valueobject.PriorityId;

public record PriorityUpdatedEvent(
        PriorityId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
