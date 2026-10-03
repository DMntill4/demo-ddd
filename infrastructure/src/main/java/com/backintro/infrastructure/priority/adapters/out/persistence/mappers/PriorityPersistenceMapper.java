package com.backintro.infrastructure.priority.adapters.out.persistence.mappers;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;

public class PriorityPersistenceMapper {
    public PriorityJpaEntity toJpa(Priority aggregate) {
        if (aggregate == null) return null;
        return new PriorityJpaEntity(aggregate.id().value(), aggregate.namePriority(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Priority toDomain(PriorityJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Priority.restore(new PriorityId(entityObj.getId()), entityObj.getNamePriority(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
