package com.backintro.domain.contact.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.contact.model.valueobject.ContactId;

public record ContactDeletedEvent(
        ContactId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
