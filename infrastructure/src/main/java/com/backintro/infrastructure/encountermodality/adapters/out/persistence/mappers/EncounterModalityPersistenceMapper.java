package com.backintro.infrastructure.encountermodality.adapters.out.persistence.mappers;

import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityJpaEntity;

public class EncounterModalityPersistenceMapper {
    public EncounterModalityJpaEntity toJpa(EncounterModality aggregate) {
        if (aggregate == null) return null;
        return new EncounterModalityJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EncounterModality toDomain(EncounterModalityJpaEntity entityObj) {
        if (entityObj == null) return null;
        return EncounterModality.restore(new EncounterModalityId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
