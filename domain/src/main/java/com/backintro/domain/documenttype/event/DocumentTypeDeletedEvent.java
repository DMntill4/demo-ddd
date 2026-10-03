package com.backintro.domain.documenttype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public record DocumentTypeDeletedEvent(
        DocumentTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
