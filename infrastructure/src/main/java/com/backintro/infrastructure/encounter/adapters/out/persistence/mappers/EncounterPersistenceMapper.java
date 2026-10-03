package com.backintro.infrastructure.encounter.adapters.out.persistence.mappers;

import com.backintro.domain.encounter.model.aggregate.Encounter;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;

public class EncounterPersistenceMapper {
    public EncounterJpaEntity toJpa(Encounter aggregate) {
        if (aggregate == null) return null;
        return new EncounterJpaEntity(aggregate.id().value(), aggregate.clinicalRecordId(), aggregate.professionalId(), aggregate.encounterTypeId(), aggregate.startedAt(), aggregate.endedAt(), aggregate.reasonForVisit(), aggregate.currentCondition(), aggregate.modalityId(), aggregate.statusId(), aggregate.createdAt(), aggregate.createdBy(), aggregate.updatedAt(), aggregate.updatedBy());
    }

    public Encounter toDomain(EncounterJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Encounter.restore(new EncounterId(entityObj.getId()), entityObj.getClinicalRecordId(), entityObj.getProfessionalId(), entityObj.getEncounterTypeId(), entityObj.getStartedAt(), entityObj.getEndedAt(), entityObj.getReasonForVisit(), entityObj.getCurrentCondition(), entityObj.getModalityId(), entityObj.getStatusId(), entityObj.getCreatedAt(), entityObj.getCreatedBy(), entityObj.getUpdatedAt(), entityObj.getUpdatedBy());
    }
}
