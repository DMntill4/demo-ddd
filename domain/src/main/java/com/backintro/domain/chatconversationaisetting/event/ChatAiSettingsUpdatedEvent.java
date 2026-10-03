package com.backintro.domain.chatconversationaisetting.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;

public record ChatAiSettingsUpdatedEvent(
        ChatAiSettingsId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
