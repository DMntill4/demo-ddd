package com.backintro.application.documenttype.usecase;

import com.backintro.application.documenttype.command.RegisterDocumentTypeCommand;
import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class RegisterDocumentTypeUseCase {
    private final DocumentTypeRepository repository;

    public RegisterDocumentTypeUseCase(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    public DocumentTypeResponse execute(RegisterDocumentTypeCommand command) {
        DocumentType aggregate = DocumentType.register(command.code(), command.name());
        DocumentType saved = repository.save(aggregate);
        return DocumentTypeResponse.fromDomain(saved);
    }
}
