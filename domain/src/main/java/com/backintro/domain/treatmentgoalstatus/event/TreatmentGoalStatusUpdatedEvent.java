package com.backintro.domain.treatmentgoalstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public record TreatmentGoalStatusUpdatedEvent(
        TreatmentGoalStatusId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
