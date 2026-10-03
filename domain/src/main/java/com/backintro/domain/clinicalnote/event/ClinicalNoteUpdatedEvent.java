package com.backintro.domain.clinicalnote.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public record ClinicalNoteUpdatedEvent(
        ClinicalNoteId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
