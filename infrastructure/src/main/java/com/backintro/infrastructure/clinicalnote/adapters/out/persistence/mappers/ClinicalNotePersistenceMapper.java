package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.mappers;

import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;

public class ClinicalNotePersistenceMapper {
    public ClinicalNoteJpaEntity toJpa(ClinicalNote aggregate) {
        if (aggregate == null) return null;
        return new ClinicalNoteJpaEntity(aggregate.id().value(), aggregate.encounterId(), aggregate.professionalId(), aggregate.subjective(), aggregate.objective(), aggregate.assessment(), aggregate.plan(), aggregate.additionalNotes(), aggregate.signedAt(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ClinicalNote toDomain(ClinicalNoteJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ClinicalNote.restore(new ClinicalNoteId(entityObj.getId()), entityObj.getEncounterId(), entityObj.getProfessionalId(), entityObj.getSubjective(), entityObj.getObjective(), entityObj.getAssessment(), entityObj.getPlan(), entityObj.getAdditionalNotes(), entityObj.getSignedAt(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
