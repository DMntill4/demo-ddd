package com.backintro.domain.citymunicipality.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record CityMunicipalityUpdatedEvent(
        CityMunicipalityId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
