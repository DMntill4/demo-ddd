package com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;

public class PatientAllergyRepositoryAdapter implements PatientAllergyRepository {
    private final PatientAllergyJpaRepository repository;
    private final PatientAllergyPersistenceMapper mapper;

    public PatientAllergyRepositoryAdapter(PatientAllergyJpaRepository repository, PatientAllergyPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PatientAllergy save(PatientAllergy aggregate) {
        PatientAllergyJpaEntity entityObj = mapper.toJpa(aggregate);
        PatientAllergyJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PatientAllergy> findById(PatientAllergyId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PatientAllergy> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PatientAllergy aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
