package com.backintro.infrastructure.risklevel.adapters.out.persistence.mappers;

import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;

public class RiskLevelPersistenceMapper {
    public RiskLevelJpaEntity toJpa(RiskLevel aggregate) {
        if (aggregate == null) return null;
        return new RiskLevelJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.severity(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public RiskLevel toDomain(RiskLevelJpaEntity entityObj) {
        if (entityObj == null) return null;
        return RiskLevel.restore(new RiskLevelId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getSeverity(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
