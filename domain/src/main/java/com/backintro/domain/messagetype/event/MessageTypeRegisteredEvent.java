package com.backintro.domain.messagetype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public record MessageTypeRegisteredEvent(
        MessageTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
