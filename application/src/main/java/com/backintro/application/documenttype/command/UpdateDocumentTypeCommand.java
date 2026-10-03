package com.backintro.application.documenttype.command;

import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public record UpdateDocumentTypeCommand(DocumentTypeId id, String code, String name) {
}
