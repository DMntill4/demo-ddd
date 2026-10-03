package com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.mappers.EscalationStatusPersistenceMapper;

public class EscalationStatusRepositoryAdapter implements EscalationStatusRepository {
    private final EscalationStatusJpaRepository repository;
    private final EscalationStatusPersistenceMapper mapper;

    public EscalationStatusRepositoryAdapter(EscalationStatusJpaRepository repository, EscalationStatusPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EscalationStatus save(EscalationStatus aggregate) {
        EscalationStatusJpaEntity entityObj = mapper.toJpa(aggregate);
        EscalationStatusJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EscalationStatus> findById(EscalationStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EscalationStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EscalationStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
