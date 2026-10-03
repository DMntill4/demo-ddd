package com.backintro.application.documenttype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public class DocumentTypeNotFoundApplicationException extends ApplicationException {
    public DocumentTypeNotFoundApplicationException(DocumentTypeId id) {
        super("DocumentType with id " + id.value() + " was not found.");
    }
}
