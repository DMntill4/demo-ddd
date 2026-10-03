package com.backintro.domain.relationshiptype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public class RelationshipTypeNotFoundException extends DomainException {
    public RelationshipTypeNotFoundException(RelationshipTypeId id) {
        super("RelationshipType with id " + id.value() + " was not found.");
    }
}
