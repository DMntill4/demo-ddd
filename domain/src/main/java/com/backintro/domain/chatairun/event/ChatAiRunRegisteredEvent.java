package com.backintro.domain.chatairun.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public record ChatAiRunRegisteredEvent(
        ChatAiRunId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
