package com.backintro.infrastructure.contact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;
import com.backintro.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;

public class ContactRepositoryAdapter implements ContactRepository {
    private final ContactJpaRepository repository;
    private final ContactPersistenceMapper mapper;

    public ContactRepositoryAdapter(ContactJpaRepository repository, ContactPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Contact save(Contact aggregate) {
        ContactJpaEntity entityObj = mapper.toJpa(aggregate);
        ContactJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Contact> findById(ContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Contact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
