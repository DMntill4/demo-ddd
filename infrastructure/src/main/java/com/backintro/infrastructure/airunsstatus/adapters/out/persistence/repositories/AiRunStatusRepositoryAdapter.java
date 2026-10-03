package com.backintro.infrastructure.airunsstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;

public class AiRunStatusRepositoryAdapter implements AiRunStatusRepository {
    private final AiRunStatusJpaRepository repository;
    private final AiRunStatusPersistenceMapper mapper;

    public AiRunStatusRepositoryAdapter(AiRunStatusJpaRepository repository, AiRunStatusPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AiRunStatus save(AiRunStatus aggregate) {
        AiRunStatusJpaEntity entityObj = mapper.toJpa(aggregate);
        AiRunStatusJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiRunStatus> findById(AiRunStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<AiRunStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(AiRunStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
