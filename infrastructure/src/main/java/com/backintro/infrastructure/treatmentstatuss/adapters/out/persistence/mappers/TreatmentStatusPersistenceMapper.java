package com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;
import com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.entity.TreatmentStatusJpaEntity;

public class TreatmentStatusPersistenceMapper {
    public TreatmentStatusJpaEntity toJpa(TreatmentStatus aggregate) {
        if (aggregate == null) return null;
        return new TreatmentStatusJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public TreatmentStatus toDomain(TreatmentStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentStatus.restore(new TreatmentStatusId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
