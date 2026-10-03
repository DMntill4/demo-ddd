package com.backintro.domain.riskassessment.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public record RiskAssessmentUpdatedEvent(
        RiskAssessmentId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
