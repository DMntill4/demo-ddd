package com.backintro.infrastructure.conversationstatus.adapters.out.persistence.mappers;

import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;

public class ConversationStatusPersistenceMapper {
    public ConversationStatusJpaEntity toJpa(ConversationStatus aggregate) {
        if (aggregate == null) return null;
        return new ConversationStatusJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public ConversationStatus toDomain(ConversationStatusJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ConversationStatus.restore(
                new ConversationStatusId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
