package com.backintro.infrastructure.sendertype.adapters.out.persistence.mappers;

import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;

public class SenderTypePersistenceMapper {
    public SenderTypeJpaEntity toJpa(SenderType aggregate) {
        if (aggregate == null) return null;
        return new SenderTypeJpaEntity(aggregate.id().value(), aggregate.nameType(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public SenderType toDomain(SenderTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return SenderType.restore(new SenderTypeId(entityObj.getId()), entityObj.getNameType(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
