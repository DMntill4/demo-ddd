package com.backintro.domain.patientallergy.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public record PatientAllergyUpdatedEvent(
        PatientAllergyId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
