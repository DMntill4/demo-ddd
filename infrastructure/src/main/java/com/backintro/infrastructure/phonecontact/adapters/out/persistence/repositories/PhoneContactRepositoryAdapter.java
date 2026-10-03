package com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;

public class PhoneContactRepositoryAdapter implements PhoneContactRepository {
    private final PhoneContactJpaRepository repository;
    private final PhoneContactPersistenceMapper mapper;

    public PhoneContactRepositoryAdapter(PhoneContactJpaRepository repository, PhoneContactPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PhoneContact save(PhoneContact aggregate) {
        PhoneContactJpaEntity entityObj = mapper.toJpa(aggregate);
        PhoneContactJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PhoneContact> findById(PhoneContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PhoneContact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PhoneContact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
