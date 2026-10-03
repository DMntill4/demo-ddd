package com.backintro.domain.encounterstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public record EncounterStatusDeletedEvent(
        EncounterStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
