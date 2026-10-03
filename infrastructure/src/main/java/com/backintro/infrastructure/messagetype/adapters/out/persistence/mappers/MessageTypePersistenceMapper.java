package com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers;

import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeJpaEntity;

public class MessageTypePersistenceMapper {
    public MessageTypeJpaEntity toJpa(MessageType aggregate) {
        if (aggregate == null) return null;
        return new MessageTypeJpaEntity(aggregate.id().value(), aggregate.nameType(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public MessageType toDomain(MessageTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return MessageType.restore(new MessageTypeId(entityObj.getId()), entityObj.getNameType(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
