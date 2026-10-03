package com.backintro.infrastructure.escalationstatus.adapters.out.persistence.mappers;

import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.infrastructure.escalationstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;

public class EscalationStatusPersistenceMapper {
    public EscalationStatusJpaEntity toJpa(EscalationStatus aggregate) {
        if (aggregate == null) return null;
        return new EscalationStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public EscalationStatus toDomain(EscalationStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return EscalationStatus.restore(
                new EscalationStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
