package com.backintro.application.relationshiptype.command;

import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public record UpdateRelationshipTypeCommand(RelationshipTypeId id, String description) {
}
