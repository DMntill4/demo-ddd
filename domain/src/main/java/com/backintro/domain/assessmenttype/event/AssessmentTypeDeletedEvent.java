package com.backintro.domain.assessmenttype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public record AssessmentTypeDeletedEvent(
        AssessmentTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
