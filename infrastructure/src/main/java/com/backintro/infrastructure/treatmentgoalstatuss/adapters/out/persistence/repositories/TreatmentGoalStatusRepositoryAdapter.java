package com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentgoalstatuss.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.mappers.TreatmentGoalStatusPersistenceMapper;

public class TreatmentGoalStatusRepositoryAdapter implements TreatmentGoalStatusRepository {
    private final TreatmentGoalStatusJpaRepository repository;
    private final TreatmentGoalStatusPersistenceMapper mapper;

    public TreatmentGoalStatusRepositoryAdapter(TreatmentGoalStatusJpaRepository repository, TreatmentGoalStatusPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentGoalStatus save(TreatmentGoalStatus aggregate) {
        TreatmentGoalStatusJpaEntity entityObj = mapper.toJpa(aggregate);
        TreatmentGoalStatusJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<TreatmentGoalStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(TreatmentGoalStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
