package com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers;

import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactJpaEntity;

public class PatientContactPersistenceMapper {
    public PatientContactJpaEntity toJpa(PatientContact aggregate) {
        if (aggregate == null) return null;
        return new PatientContactJpaEntity(aggregate.id().value(), aggregate.contactId(), aggregate.patientId(), aggregate.isPrimaryContact(), aggregate.isEmergencyContact(), aggregate.relationshipTypeId());
    }

    public PatientContact toDomain(PatientContactJpaEntity entityObj) {
        if (entityObj == null) return null;
        return PatientContact.restore(new PatientContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getPatientId(), entityObj.getIsPrimaryContact(), entityObj.getIsEmergencyContact(), entityObj.getRelationshipTypeId());
    }
}
