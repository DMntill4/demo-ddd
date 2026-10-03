package com.backintro.domain.relationshiptype.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public interface RelationshipTypeRepository {
    RelationshipType save(RelationshipType aggregate);
    Optional<RelationshipType> findById(RelationshipTypeId id);
    List<RelationshipType> findAll();
    void delete(RelationshipType aggregate);
}
