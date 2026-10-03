package com.backintro.application.relationshiptype.usecase;

import java.util.List;
import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class ListRelationshipTypeUseCase {
    private final RelationshipTypeRepository repository;

    public ListRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        this.repository = repository;
    }

    public List<RelationshipTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(RelationshipTypeResponse::fromDomain)
                .toList();
    }
}
