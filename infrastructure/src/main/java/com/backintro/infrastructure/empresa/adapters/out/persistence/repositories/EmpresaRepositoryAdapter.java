package com.backintro.infrastructure.empresa.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;
import com.backintro.infrastructure.empresa.adapters.out.persistence.mappers.EmpresaPersistenceMapper;

public class EmpresaRepositoryAdapter implements EmpresaRepository {
    private final EmpresaJpaRepository repository;
    private final EmpresaPersistenceMapper mapper;

    public EmpresaRepositoryAdapter(EmpresaJpaRepository repository, EmpresaPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Empresa save(Empresa aggregate) {
        EmpresaJpaEntity entityObj = mapper.toJpa(aggregate);
        EmpresaJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Empresa> findById(EmpresaId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Empresa> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Empresa aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
