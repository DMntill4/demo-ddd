package com.backintro.infrastructure.encounter.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encounter.model.aggregate.Encounter;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;
import com.backintro.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;

public class EncounterRepositoryAdapter implements EncounterRepository {
    private final EncounterJpaRepository repository;
    private final EncounterPersistenceMapper mapper;

    public EncounterRepositoryAdapter(EncounterJpaRepository repository, EncounterPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Encounter save(Encounter aggregate) {
        EncounterJpaEntity entityObj = mapper.toJpa(aggregate);
        EncounterJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Encounter> findById(EncounterId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Encounter> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Encounter aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
