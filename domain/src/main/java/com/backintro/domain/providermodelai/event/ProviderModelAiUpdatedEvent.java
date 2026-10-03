package com.backintro.domain.providermodelai.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public record ProviderModelAiUpdatedEvent(
        ProviderModelAiId id,
        String name,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
}
