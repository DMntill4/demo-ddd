package com.backintro.domain.conversationstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;

public record ConversationStatusUpdatedEvent(
        ConversationStatusId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
