package com.backintro.infrastructure.risklevel.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.mappers.RiskLevelPersistenceMapper;

public class RiskLevelRepositoryAdapter implements RiskLevelRepository {
    private final RiskLevelJpaRepository repository;
    private final RiskLevelPersistenceMapper mapper;

    public RiskLevelRepositoryAdapter(RiskLevelJpaRepository repository, RiskLevelPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RiskLevel save(RiskLevel aggregate) {
        RiskLevelJpaEntity entityObj = mapper.toJpa(aggregate);
        RiskLevelJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskLevel> findById(RiskLevelId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<RiskLevel> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(RiskLevel aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
