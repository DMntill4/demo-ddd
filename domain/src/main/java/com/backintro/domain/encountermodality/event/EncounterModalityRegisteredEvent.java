package com.backintro.domain.encountermodality.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public record EncounterModalityRegisteredEvent(
        EncounterModalityId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
