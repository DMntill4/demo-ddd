package com.backintro.infrastructure.documenttype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.entity.DocumentTypeJpaEntity;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.mappers.DocumentTypePersistenceMapper;

public class DocumentTypeRepositoryAdapter implements DocumentTypeRepository {
    private final DocumentTypeJpaRepository repository;
    private final DocumentTypePersistenceMapper mapper;

    public DocumentTypeRepositoryAdapter(DocumentTypeJpaRepository repository, DocumentTypePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DocumentType save(DocumentType aggregate) {
        DocumentTypeJpaEntity entityObj = mapper.toJpa(aggregate);
        DocumentTypeJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<DocumentType> findById(DocumentTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<DocumentType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(DocumentType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
