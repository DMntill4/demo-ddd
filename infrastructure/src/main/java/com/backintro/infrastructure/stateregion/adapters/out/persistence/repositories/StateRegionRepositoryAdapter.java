package com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;

public class StateRegionRepositoryAdapter implements StateRegionRepository {
    private final StateRegionJpaRepository repository;
    private final StateRegionPersistenceMapper mapper;

    public StateRegionRepositoryAdapter(StateRegionJpaRepository repository, StateRegionPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StateRegion save(StateRegion aggregate) {
        StateRegionJpaEntity entityObj = mapper.toJpa(aggregate);
        StateRegionJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<StateRegion> findById(StateRegionId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<StateRegion> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(StateRegion aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
