package com.backintro.domain.chatconversation.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public record ChatConversationRegisteredEvent(
        ChatConversationId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
