package com.backintro.domain.aimodel.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public record AiModelUpdatedEvent(
        AiModelId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
