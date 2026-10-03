package com.backintro.domain.encounter.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encounter.model.valueobject.EncounterId;

public record EncounterDeletedEvent(
        EncounterId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
