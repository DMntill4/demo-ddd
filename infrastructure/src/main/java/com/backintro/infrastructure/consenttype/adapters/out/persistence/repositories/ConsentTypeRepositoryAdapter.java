package com.backintro.infrastructure.consenttype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;

public class ConsentTypeRepositoryAdapter implements ConsentTypeRepository {
    private final ConsentTypeJpaRepository repository;
    private final ConsentTypePersistenceMapper mapper;

    public ConsentTypeRepositoryAdapter(ConsentTypeJpaRepository repository, ConsentTypePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ConsentType save(ConsentType aggregate) {
        ConsentTypeJpaEntity entityObj = mapper.toJpa(aggregate);
        ConsentTypeJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ConsentType> findById(ConsentTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ConsentType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ConsentType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
