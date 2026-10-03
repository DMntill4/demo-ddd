package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;

public class TreatmentGoalPersistenceMapper {
    public TreatmentGoalJpaEntity toJpa(TreatmentGoal aggregate) {
        if (aggregate == null) return null;
        return new TreatmentGoalJpaEntity(aggregate.id().value(), aggregate.treatmentPlanId(), aggregate.description(), aggregate.targetDate(), aggregate.completedAt(), aggregate.notes(), aggregate.treatmentGoalStatusId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public TreatmentGoal toDomain(TreatmentGoalJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentGoal.restore(new TreatmentGoalId(entityObj.getId()), entityObj.getTreatmentPlanId(), entityObj.getDescription(), entityObj.getTargetDate(), entityObj.getCompletedAt(), entityObj.getNotes(), entityObj.getTreatmentGoalStatusId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
