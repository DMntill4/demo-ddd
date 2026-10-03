package com.backintro.domain.citymunicipality.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record CityMunicipalityRegisteredEvent(
        CityMunicipalityId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
