package com.backintro.infrastructure.encounterstatus.adapters.out.persistence.mappers;

import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;

public class EncounterStatusPersistenceMapper {
    public EncounterStatusJpaEntity toJpa(EncounterStatus aggregate) {
        if (aggregate == null) return null;
        return new EncounterStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public EncounterStatus toDomain(EncounterStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return EncounterStatus.restore(
                new EncounterStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
