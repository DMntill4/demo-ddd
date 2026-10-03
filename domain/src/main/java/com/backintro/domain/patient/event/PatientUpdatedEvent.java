package com.backintro.domain.patient.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.patient.model.valueobject.PatientId;

public record PatientUpdatedEvent(
        PatientId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
