package com.backintro.infrastructure.patient.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;
import com.backintro.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;

public class PatientRepositoryAdapter implements PatientRepository {
    private final PatientJpaRepository repository;
    private final PatientPersistenceMapper mapper;

    public PatientRepositoryAdapter(PatientJpaRepository repository, PatientPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient aggregate) {
        PatientJpaEntity entityObj = mapper.toJpa(aggregate);
        PatientJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Patient> findById(PatientId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Patient aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
