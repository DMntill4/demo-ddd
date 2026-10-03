package com.backintro.domain.medicationroute.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public record MedicationRouteRegisteredEvent(
        MedicationRouteId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
