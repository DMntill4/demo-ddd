package com.backintro.domain.phonecontact.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public record PhoneContactDeletedEvent(
        PhoneContactId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
