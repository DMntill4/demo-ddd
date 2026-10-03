package com.backintro.domain.consenttype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public record ConsentTypeDeletedEvent(
        ConsentTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
