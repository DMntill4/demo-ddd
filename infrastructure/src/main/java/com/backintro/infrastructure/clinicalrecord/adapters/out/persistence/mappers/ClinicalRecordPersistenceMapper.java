package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers;

import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;

public class ClinicalRecordPersistenceMapper {
    public ClinicalRecordJpaEntity toJpa(ClinicalRecord aggregate) {
        if (aggregate == null) return null;
        return new ClinicalRecordJpaEntity(aggregate.id().value(), aggregate.patientId(), aggregate.creationDate(), aggregate.recordNumber(), aggregate.openedAt(), aggregate.closedAt(), aggregate.statusId(), aggregate.createdAt(), aggregate.createdBy());
    }

    public ClinicalRecord toDomain(ClinicalRecordJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ClinicalRecord.restore(new ClinicalRecordId(entityObj.getId()), entityObj.getPatientId(), entityObj.getCreationDate(), entityObj.getRecordNumber(), entityObj.getOpenedAt(), entityObj.getClosedAt(), entityObj.getStatusId(), entityObj.getCreatedAt(), entityObj.getCreatedBy());
    }
}
