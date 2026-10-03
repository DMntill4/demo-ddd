package com.backintro.domain.professional.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public record ProfessionalDeletedEvent(
        ProfessionalId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
