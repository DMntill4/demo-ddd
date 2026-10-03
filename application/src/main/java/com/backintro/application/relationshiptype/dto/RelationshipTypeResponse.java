package com.backintro.application.relationshiptype.dto;

import java.util.UUID;

import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;

public record RelationshipTypeResponse(UUID id, String description) {
    public static RelationshipTypeResponse fromDomain(RelationshipType aggregate) {
        return new RelationshipTypeResponse(aggregate.id().value(), aggregate.description());
    }
}
