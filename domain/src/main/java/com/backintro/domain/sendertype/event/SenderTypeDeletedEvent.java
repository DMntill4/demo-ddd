package com.backintro.domain.sendertype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public record SenderTypeDeletedEvent(
        SenderTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
