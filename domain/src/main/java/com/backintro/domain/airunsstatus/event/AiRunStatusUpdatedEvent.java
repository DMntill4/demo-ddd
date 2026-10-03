package com.backintro.domain.airunsstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public record AiRunStatusUpdatedEvent(
        AiRunStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
