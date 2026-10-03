package com.backintro.domain.chataisettings.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;

public record ChatAiSettingsDeletedEvent(
        ChatAiSettingsId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
