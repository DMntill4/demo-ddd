package com.backintro.infrastructure.priority.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;
import com.backintro.infrastructure.priority.adapters.out.persistence.mappers.PriorityPersistenceMapper;

public class PriorityRepositoryAdapter implements PriorityRepository {
    private final PriorityJpaRepository repository;
    private final PriorityPersistenceMapper mapper;

    public PriorityRepositoryAdapter(PriorityJpaRepository repository, PriorityPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Priority save(Priority aggregate) {
        PriorityJpaEntity entityObj = mapper.toJpa(aggregate);
        PriorityJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Priority> findById(PriorityId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Priority> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Priority aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
