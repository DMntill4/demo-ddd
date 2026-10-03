package com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers;

import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;

public class ProfessionalTypePersistenceMapper {
    public ProfessionalTypeJpaEntity toJpa(ProfessionalType aggregate) {
        if (aggregate == null) return null;
        return new ProfessionalTypeJpaEntity(aggregate.id().value(), aggregate.name(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ProfessionalType toDomain(ProfessionalTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ProfessionalType.restore(new ProfessionalTypeId(entityObj.getId()), entityObj.getName(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
