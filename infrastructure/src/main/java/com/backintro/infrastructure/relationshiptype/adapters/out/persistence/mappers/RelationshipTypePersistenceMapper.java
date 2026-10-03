package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers;

import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeJpaEntity;

public class RelationshipTypePersistenceMapper {
    public RelationshipTypeJpaEntity toJpa(RelationshipType aggregate) {
        if (aggregate == null) return null;
        return new RelationshipTypeJpaEntity(aggregate.id().value(), aggregate.description());
    }

    public RelationshipType toDomain(RelationshipTypeJpaEntity entityObj) {
        if (entityObj == null) return null;
        return RelationshipType.restore(new RelationshipTypeId(entityObj.getId()), entityObj.getDescription());
    }
}
