package com.backintro.domain.conversationsstatus.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;

public record ConversationStatusDeletedEvent(
        ConversationStatusId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
