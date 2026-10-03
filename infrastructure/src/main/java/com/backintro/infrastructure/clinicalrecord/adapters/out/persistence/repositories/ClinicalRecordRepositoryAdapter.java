package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;

public class ClinicalRecordRepositoryAdapter implements ClinicalRecordRepository {
    private final ClinicalRecordJpaRepository repository;
    private final ClinicalRecordPersistenceMapper mapper;

    public ClinicalRecordRepositoryAdapter(ClinicalRecordJpaRepository repository, ClinicalRecordPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalRecord save(ClinicalRecord aggregate) {
        ClinicalRecordJpaEntity entityObj = mapper.toJpa(aggregate);
        ClinicalRecordJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecord> findById(ClinicalRecordId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ClinicalRecord> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ClinicalRecord aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
