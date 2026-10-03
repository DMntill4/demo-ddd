package com.backintro.domain.chatconversation.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public record ChatConversationDeletedEvent(
        ChatConversationId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
