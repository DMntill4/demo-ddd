package com.backintro.domain.patientcontact.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public record PatientContactDeletedEvent(
        PatientContactId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
