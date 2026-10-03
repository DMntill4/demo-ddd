package com.backintro.infrastructure.encountertype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeJpaEntity;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypePersistenceMapper;

public class EncounterTypeRepositoryAdapter implements EncounterTypeRepository {
    private final EncounterTypeJpaRepository repository;
    private final EncounterTypePersistenceMapper mapper;

    public EncounterTypeRepositoryAdapter(EncounterTypeJpaRepository repository, EncounterTypePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EncounterType save(EncounterType aggregate) {
        EncounterTypeJpaEntity entityObj = mapper.toJpa(aggregate);
        EncounterTypeJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterType> findById(EncounterTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EncounterType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EncounterType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
