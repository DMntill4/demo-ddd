package com.backintro.domain.documenttype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public class DocumentTypeNotFoundException extends DomainException {
    public DocumentTypeNotFoundException(DocumentTypeId id) {
        super("DocumentType with id " + id.value() + " was not found.");
    }
}
