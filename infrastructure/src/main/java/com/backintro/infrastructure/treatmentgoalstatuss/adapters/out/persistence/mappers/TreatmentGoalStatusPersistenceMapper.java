package com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;

public class TreatmentGoalStatusPersistenceMapper {
    public TreatmentGoalStatusJpaEntity toJpa(TreatmentGoalStatus aggregate) {
        if (aggregate == null) return null;
        return new TreatmentGoalStatusJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public TreatmentGoalStatus toDomain(TreatmentGoalStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentGoalStatus.restore(new TreatmentGoalStatusId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
