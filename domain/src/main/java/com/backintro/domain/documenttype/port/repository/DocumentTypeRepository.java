package com.backintro.domain.documenttype.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public interface DocumentTypeRepository {
    DocumentType save(DocumentType aggregate);
    Optional<DocumentType> findById(DocumentTypeId id);
    List<DocumentType> findAll();
    void delete(DocumentType aggregate);
}
