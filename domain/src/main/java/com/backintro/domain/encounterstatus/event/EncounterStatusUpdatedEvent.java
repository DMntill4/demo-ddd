package com.backintro.domain.encounterstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public record EncounterStatusUpdatedEvent(
        EncounterStatusId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
