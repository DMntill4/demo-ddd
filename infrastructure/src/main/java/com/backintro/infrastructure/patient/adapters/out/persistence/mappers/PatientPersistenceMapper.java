package com.backintro.infrastructure.patient.adapters.out.persistence.mappers;

import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;

public class PatientPersistenceMapper {
    public PatientJpaEntity toJpa(Patient aggregate) {
        if (aggregate == null) return null;
        return new PatientJpaEntity(aggregate.id().value(), aggregate.documentTypeId(), aggregate.documentNumber(), aggregate.firstName(), aggregate.middleName(), aggregate.lastName(), aggregate.secondLastName(), aggregate.birthDate(), aggregate.biologicalSexId(), aggregate.genderIdentity(), aggregate.email(), aggregate.phone(), aggregate.address(), aggregate.active(), aggregate.createdAt(), aggregate.createdBy(), aggregate.updatedAt(), aggregate.updatedBy(), aggregate.cityId());
    }

    public Patient toDomain(PatientJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Patient.restore(new PatientId(entityObj.getId()), entityObj.getDocumentTypeId(), entityObj.getDocumentNumber(), entityObj.getFirstName(), entityObj.getMiddleName(), entityObj.getLastName(), entityObj.getSecondLastName(), entityObj.getBirthDate(), entityObj.getBiologicalSexId(), entityObj.getGenderIdentity(), entityObj.getEmail(), entityObj.getPhone(), entityObj.getAddress(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getCreatedBy(), entityObj.getUpdatedAt(), entityObj.getUpdatedBy(), entityObj.getCityId());
    }
}
