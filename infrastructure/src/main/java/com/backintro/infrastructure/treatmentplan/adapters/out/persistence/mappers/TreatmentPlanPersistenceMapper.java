package com.backintro.infrastructure.treatmentplan.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanJpaEntity;

public class TreatmentPlanPersistenceMapper {
    public TreatmentPlanJpaEntity toJpa(TreatmentPlan aggregate) {
        if (aggregate == null) return null;
        return new TreatmentPlanJpaEntity(aggregate.id().value(), aggregate.encounterId(), aggregate.professionalId(), aggregate.title(), aggregate.description(), aggregate.startDate(), aggregate.endDate(), aggregate.treatmentStatusId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public TreatmentPlan toDomain(TreatmentPlanJpaEntity entityObj) {
        if (entityObj == null) return null;
        return TreatmentPlan.restore(new TreatmentPlanId(entityObj.getId()), entityObj.getEncounterId(), entityObj.getProfessionalId(), entityObj.getTitle(), entityObj.getDescription(), entityObj.getStartDate(), entityObj.getEndDate(), entityObj.getTreatmentStatusId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
