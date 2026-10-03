package com.backintro.domain.study.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.study.model.valueobject.StudyId;

public record StudyUpdatedEvent(
        StudyId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
