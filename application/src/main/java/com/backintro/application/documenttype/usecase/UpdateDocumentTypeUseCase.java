package com.backintro.application.documenttype.usecase;

import com.backintro.application.documenttype.command.UpdateDocumentTypeCommand;
import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class UpdateDocumentTypeUseCase {
    private final DocumentTypeRepository repository;

    public UpdateDocumentTypeUseCase(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    public DocumentTypeResponse execute(UpdateDocumentTypeCommand command) {
        DocumentType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new DocumentTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        DocumentType saved = repository.save(aggregate);
        return DocumentTypeResponse.fromDomain(saved);
    }
}
