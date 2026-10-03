package com.backintro.domain.treatmentstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

public record TreatmentStatusRegisteredEvent(
        TreatmentStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
