package com.backintro.domain.chatairunmetric.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public record ChatAiRunMetricRegisteredEvent(
        ChatAiRunMetricId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
