package com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;

public class ConversationStatusRepositoryAdapter implements ConversationStatusRepository {
    private final ConversationStatusJpaRepository repository;
    private final ConversationStatusPersistenceMapper mapper;

    public ConversationStatusRepositoryAdapter(ConversationStatusJpaRepository repository, ConversationStatusPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ConversationStatus save(ConversationStatus aggregate) {
        ConversationStatusJpaEntity entityObj = mapper.toJpa(aggregate);
        ConversationStatusJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ConversationStatus> findById(ConversationStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ConversationStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ConversationStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
