package com.backintro.infrastructure.patientallergy.adapters.out.persistence.mappers;

import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;

public class PatientAllergyPersistenceMapper {
    public PatientAllergyJpaEntity toJpa(PatientAllergy aggregate) {
        if (aggregate == null) return null;
        return new PatientAllergyJpaEntity(aggregate.id().value(), aggregate.patientId(), aggregate.substance(), aggregate.reaction(), aggregate.severity(), aggregate.active(), aggregate.recordedAt(), aggregate.recordedBy(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public PatientAllergy toDomain(PatientAllergyJpaEntity entityObj) {
        if (entityObj == null) return null;
        return PatientAllergy.restore(new PatientAllergyId(entityObj.getId()), entityObj.getPatientId(), entityObj.getSubstance(), entityObj.getReaction(), entityObj.getSeverity(), entityObj.getActive(), entityObj.getRecordedAt(), entityObj.getRecordedBy(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
