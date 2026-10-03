package com.backintro.infrastructure.gender.adapters.out.persistence.mappers;

import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;

public class GenderPersistenceMapper {
    public GenderJpaEntity toJpa(Gender aggregate) {
        if (aggregate == null) return null;
        return new GenderJpaEntity(aggregate.id().value(), aggregate.description(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Gender toDomain(GenderJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Gender.restore(new GenderId(entityObj.getId()), entityObj.getDescription(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
