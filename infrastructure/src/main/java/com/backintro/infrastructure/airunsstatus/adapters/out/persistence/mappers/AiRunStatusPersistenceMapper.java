package com.backintro.infrastructure.airunsstatus.adapters.out.persistence.mappers;

import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;

public class AiRunStatusPersistenceMapper {
    public AiRunStatusJpaEntity toJpa(AiRunStatus aggregate) {
        if (aggregate == null) return null;
        return new AiRunStatusJpaEntity(aggregate.id().value(), aggregate.nameStatus(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public AiRunStatus toDomain(AiRunStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return AiRunStatus.restore(new AiRunStatusId(entityObj.getId()), entityObj.getNameStatus(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
