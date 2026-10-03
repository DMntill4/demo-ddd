package com.backintro.domain.treatmentstatuss.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public record TreatmentStatusUpdatedEvent(
        TreatmentStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
