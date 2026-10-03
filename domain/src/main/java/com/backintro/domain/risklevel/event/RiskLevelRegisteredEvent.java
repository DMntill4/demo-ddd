package com.backintro.domain.risklevel.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public record RiskLevelRegisteredEvent(
        RiskLevelId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
