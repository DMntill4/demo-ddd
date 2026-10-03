package com.backintro.domain.professionaltype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public record ProfessionalTypeDeletedEvent(
        ProfessionalTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
