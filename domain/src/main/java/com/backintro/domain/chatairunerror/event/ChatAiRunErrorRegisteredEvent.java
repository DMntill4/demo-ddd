package com.backintro.domain.chatairunerror.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public record ChatAiRunErrorRegisteredEvent(
        ChatAiRunErrorId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
