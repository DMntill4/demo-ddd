package com.backintro.infrastructure.medicationroute.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteJpaEntity;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.mappers.MedicationRoutePersistenceMapper;

public class MedicationRouteRepositoryAdapter implements MedicationRouteRepository {
    private final MedicationRouteJpaRepository repository;
    private final MedicationRoutePersistenceMapper mapper;

    public MedicationRouteRepositoryAdapter(MedicationRouteJpaRepository repository, MedicationRoutePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MedicationRoute save(MedicationRoute aggregate) {
        MedicationRouteJpaEntity entityObj = mapper.toJpa(aggregate);
        MedicationRouteJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MedicationRoute> findById(MedicationRouteId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<MedicationRoute> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(MedicationRoute aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
