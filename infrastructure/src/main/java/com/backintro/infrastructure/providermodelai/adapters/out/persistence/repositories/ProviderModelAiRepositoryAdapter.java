package com.backintro.infrastructure.providermodelai.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.mappers.ProviderModelAiPersistenceMapper;

public class ProviderModelAiRepositoryAdapter implements ProviderModelAiRepository {
    private final ProviderModelAiJpaRepository repository;
    private final ProviderModelAiPersistenceMapper mapper;

    public ProviderModelAiRepositoryAdapter(ProviderModelAiJpaRepository repository, ProviderModelAiPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProviderModelAi save(ProviderModelAi aggregate) {
        ProviderModelAiJpaEntity entityObj = mapper.toJpa(aggregate);
        ProviderModelAiJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProviderModelAi> findById(ProviderModelAiId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProviderModelAi> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return repository.existsByCode(code);
    }

    @Override
    public void delete(ProviderModelAi aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
