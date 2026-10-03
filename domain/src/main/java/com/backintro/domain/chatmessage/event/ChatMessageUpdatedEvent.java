package com.backintro.domain.chatmessage.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public record ChatMessageUpdatedEvent(
        ChatMessageId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
