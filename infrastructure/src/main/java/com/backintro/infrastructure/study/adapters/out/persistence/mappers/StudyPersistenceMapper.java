package com.backintro.infrastructure.study.adapters.out.persistence.mappers;

import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.infrastructure.study.adapters.out.persistence.entity.StudyJpaEntity;

public class StudyPersistenceMapper {
    public StudyJpaEntity toJpa(Study aggregate) {
        if (aggregate == null) return null;
        return new StudyJpaEntity(aggregate.id().value(), aggregate.name(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Study toDomain(StudyJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Study.restore(new StudyId(entityObj.getId()), entityObj.getName(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
