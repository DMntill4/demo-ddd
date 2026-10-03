package com.backintro.domain.treatmentplan.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public record TreatmentPlanDeletedEvent(
        TreatmentPlanId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
