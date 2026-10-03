package com.backintro.infrastructure.encountertype.adapters.out.persistence.mappers;

import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeJpaEntity;

public class EncounterTypePersistenceMapper {
    public EncounterTypeJpaEntity toJpa(EncounterType aggregate) {
        if (aggregate == null) return null;
        return new EncounterTypeJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EncounterType toDomain(EncounterTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return EncounterType.restore(new EncounterTypeId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
