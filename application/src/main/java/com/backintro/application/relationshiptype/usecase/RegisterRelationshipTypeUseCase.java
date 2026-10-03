package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.command.RegisterRelationshipTypeCommand;
import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class RegisterRelationshipTypeUseCase {
    private final RelationshipTypeRepository repository;

    public RegisterRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        this.repository = repository;
    }

    public RelationshipTypeResponse execute(RegisterRelationshipTypeCommand command) {
        RelationshipType aggregate = RelationshipType.register(command.description());
        RelationshipType saved = repository.save(aggregate);
        return RelationshipTypeResponse.fromDomain(saved);
    }
}
