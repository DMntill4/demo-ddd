package com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;

public class EmailContactRepositoryAdapter implements EmailContactRepository {
    private final EmailContactJpaRepository repository;
    private final EmailContactPersistenceMapper mapper;

    public EmailContactRepositoryAdapter(EmailContactJpaRepository repository, EmailContactPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmailContact save(EmailContact aggregate) {
        EmailContactJpaEntity entityObj = mapper.toJpa(aggregate);
        EmailContactJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EmailContact> findById(EmailContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EmailContact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EmailContact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
