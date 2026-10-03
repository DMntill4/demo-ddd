package com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;

public class TreatmentGoalStatusPersistenceMapper {
    public TreatmentGoalStatusJpaEntity toJpa(TreatmentGoalStatus aggregate) {
        if (aggregate == null) return null;
        return new TreatmentGoalStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public TreatmentGoalStatus toDomain(TreatmentGoalStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentGoalStatus.restore(
                new TreatmentGoalStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
