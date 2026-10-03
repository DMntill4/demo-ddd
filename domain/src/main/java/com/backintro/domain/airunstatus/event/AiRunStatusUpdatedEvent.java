package com.backintro.domain.airunstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;

public record AiRunStatusUpdatedEvent(
        AiRunStatusId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
