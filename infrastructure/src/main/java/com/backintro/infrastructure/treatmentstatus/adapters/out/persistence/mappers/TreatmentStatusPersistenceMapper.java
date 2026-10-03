package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;

public class TreatmentStatusPersistenceMapper {
    public TreatmentStatusJpaEntity toJpa(TreatmentStatus aggregate) {
        if (aggregate == null) return null;
        return new TreatmentStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public TreatmentStatus toDomain(TreatmentStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentStatus.restore(
                new TreatmentStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
