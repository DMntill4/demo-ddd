package com.backintro.domain.mentalstatusexam.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public record MentalStatusExamRegisteredEvent(
        MentalStatusExamId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
