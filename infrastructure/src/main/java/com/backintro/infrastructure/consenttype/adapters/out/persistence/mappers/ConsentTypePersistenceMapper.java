package com.backintro.infrastructure.consenttype.adapters.out.persistence.mappers;

import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;

public class ConsentTypePersistenceMapper {
    public ConsentTypeJpaEntity toJpa(ConsentType aggregate) {
        if (aggregate == null) return null;
        return new ConsentTypeJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.description(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ConsentType toDomain(ConsentTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ConsentType.restore(new ConsentTypeId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getDescription(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
