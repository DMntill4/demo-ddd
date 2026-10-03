package com.backintro.domain.encounterstatuss.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;

public record EncounterStatusDeletedEvent(
        EncounterStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
