package com.backintro.infrastructure.airunstatus.adapters.out.persistence.mappers;

import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;

public class AiRunStatusPersistenceMapper {
    public AiRunStatusJpaEntity toJpa(AiRunStatus aggregate) {
        if (aggregate == null) return null;
        return new AiRunStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public AiRunStatus toDomain(AiRunStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return AiRunStatus.restore(
                new AiRunStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
