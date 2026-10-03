package com.backintro.domain.country.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.country.model.valueobject.CountryId;

public record CountryDeletedEvent(
        CountryId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
