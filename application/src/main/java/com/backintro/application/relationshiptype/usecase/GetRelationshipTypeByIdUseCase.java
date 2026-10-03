package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class GetRelationshipTypeByIdUseCase {
    private final RelationshipTypeRepository repository;

    public GetRelationshipTypeByIdUseCase(RelationshipTypeRepository repository) {
        this.repository = repository;
    }

    public RelationshipTypeResponse execute(RelationshipTypeId id) {
        return repository.findById(id)
                .map(RelationshipTypeResponse::fromDomain)
                .orElseThrow(() -> new RelationshipTypeNotFoundApplicationException(id));
    }
}
