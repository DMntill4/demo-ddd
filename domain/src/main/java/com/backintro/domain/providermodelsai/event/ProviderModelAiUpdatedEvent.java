package com.backintro.domain.providermodelsai.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;

public record ProviderModelAiUpdatedEvent(
        ProviderModelAiId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
