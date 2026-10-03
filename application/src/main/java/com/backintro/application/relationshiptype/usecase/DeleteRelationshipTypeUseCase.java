package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class DeleteRelationshipTypeUseCase {
    private final RelationshipTypeRepository repository;

    public DeleteRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(RelationshipTypeId id) {
        RelationshipType aggregate = repository.findById(id)
                .orElseThrow(() -> new RelationshipTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
