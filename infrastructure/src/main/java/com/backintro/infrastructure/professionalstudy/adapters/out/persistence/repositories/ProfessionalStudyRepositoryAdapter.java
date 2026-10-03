package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyJpaEntity;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyPersistenceMapper;

public class ProfessionalStudyRepositoryAdapter implements ProfessionalStudyRepository {
    private final ProfessionalStudyJpaRepository repository;
    private final ProfessionalStudyPersistenceMapper mapper;

    public ProfessionalStudyRepositoryAdapter(ProfessionalStudyJpaRepository repository, ProfessionalStudyPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalStudy save(ProfessionalStudy aggregate) {
        ProfessionalStudyJpaEntity entityObj = mapper.toJpa(aggregate);
        ProfessionalStudyJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalStudy> findById(ProfessionalStudyId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalStudy> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProfessionalStudy aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
