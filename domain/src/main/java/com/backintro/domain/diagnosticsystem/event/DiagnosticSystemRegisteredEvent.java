package com.backintro.domain.diagnosticsystem.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public record DiagnosticSystemRegisteredEvent(
        DiagnosticSystemId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
