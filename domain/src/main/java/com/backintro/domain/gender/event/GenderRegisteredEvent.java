package com.backintro.domain.gender.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.gender.model.valueobject.GenderId;

public record GenderRegisteredEvent(
        GenderId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
