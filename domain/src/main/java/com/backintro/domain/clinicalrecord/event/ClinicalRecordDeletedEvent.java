package com.backintro.domain.clinicalrecord.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public record ClinicalRecordDeletedEvent(
        ClinicalRecordId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
