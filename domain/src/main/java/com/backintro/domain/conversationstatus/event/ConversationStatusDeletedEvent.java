package com.backintro.domain.conversationstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;

public record ConversationStatusDeletedEvent(
        ConversationStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
