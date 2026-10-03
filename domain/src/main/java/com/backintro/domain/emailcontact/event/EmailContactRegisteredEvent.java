package com.backintro.domain.emailcontact.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public record EmailContactRegisteredEvent(
        EmailContactId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
