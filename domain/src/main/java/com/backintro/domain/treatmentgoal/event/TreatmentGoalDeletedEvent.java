package com.backintro.domain.treatmentgoal.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public record TreatmentGoalDeletedEvent(
        TreatmentGoalId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
