package com.backintro.domain.empresa.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public record EmpresaUpdatedEvent(
        EmpresaId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
