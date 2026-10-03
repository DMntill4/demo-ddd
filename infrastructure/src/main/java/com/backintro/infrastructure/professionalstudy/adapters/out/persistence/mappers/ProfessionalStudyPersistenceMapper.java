package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers;

import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyJpaEntity;

public class ProfessionalStudyPersistenceMapper {
    public ProfessionalStudyJpaEntity toJpa(ProfessionalStudy aggregate) {
        if (aggregate == null) return null;
        return new ProfessionalStudyJpaEntity(aggregate.id().value(), aggregate.studyId(), aggregate.professionalId(), aggregate.title(), aggregate.university(), aggregate.isValid(), aggregate.resolutionNumber(), aggregate.countryId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ProfessionalStudy toDomain(ProfessionalStudyJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ProfessionalStudy.restore(new ProfessionalStudyId(entityObj.getId()), entityObj.getStudyId(), entityObj.getProfessionalId(), entityObj.getTitle(), entityObj.getUniversity(), entityObj.getIsValid(), entityObj.getResolutionNumber(), entityObj.getCountryId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
