package com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentJpaEntity;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;

public class RiskAssessmentRepositoryAdapter implements RiskAssessmentRepository {
    private final RiskAssessmentJpaRepository repository;
    private final RiskAssessmentPersistenceMapper mapper;

    public RiskAssessmentRepositoryAdapter(RiskAssessmentJpaRepository repository, RiskAssessmentPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RiskAssessment save(RiskAssessment aggregate) {
        RiskAssessmentJpaEntity entityObj = mapper.toJpa(aggregate);
        RiskAssessmentJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskAssessment> findById(RiskAssessmentId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<RiskAssessment> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(RiskAssessment aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
