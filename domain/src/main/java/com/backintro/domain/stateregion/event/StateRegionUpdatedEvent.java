package com.backintro.domain.stateregion.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public record StateRegionUpdatedEvent(
        StateRegionId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
