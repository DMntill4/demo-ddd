package com.backintro.domain.treatmentgoalstatuss.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;

public record TreatmentGoalStatusDeletedEvent(
        TreatmentGoalStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
