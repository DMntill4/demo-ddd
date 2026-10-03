package com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.entity.EncounterStatusJpaEntity;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;

public class EncounterStatusRepositoryAdapter implements EncounterStatusRepository {
    private final EncounterStatusJpaRepository repository;
    private final EncounterStatusPersistenceMapper mapper;

    public EncounterStatusRepositoryAdapter(EncounterStatusJpaRepository repository, EncounterStatusPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EncounterStatus save(EncounterStatus aggregate) {
        EncounterStatusJpaEntity entityObj = mapper.toJpa(aggregate);
        EncounterStatusJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterStatus> findById(EncounterStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EncounterStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EncounterStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
