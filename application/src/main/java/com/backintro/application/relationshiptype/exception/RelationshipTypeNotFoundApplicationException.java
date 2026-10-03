package com.backintro.application.relationshiptype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public class RelationshipTypeNotFoundApplicationException extends ApplicationException {
    public RelationshipTypeNotFoundApplicationException(RelationshipTypeId id) {
        super("RelationshipType with id " + id.value() + " was not found.");
    }
}
