package com.backintro.domain.encountertype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public record EncounterTypeDeletedEvent(
        EncounterTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
