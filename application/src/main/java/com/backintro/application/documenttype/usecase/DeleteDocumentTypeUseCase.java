package com.backintro.application.documenttype.usecase;

import com.backintro.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class DeleteDocumentTypeUseCase {
    private final DocumentTypeRepository repository;

    public DeleteDocumentTypeUseCase(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(DocumentTypeId id) {
        DocumentType aggregate = repository.findById(id)
                .orElseThrow(() -> new DocumentTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
