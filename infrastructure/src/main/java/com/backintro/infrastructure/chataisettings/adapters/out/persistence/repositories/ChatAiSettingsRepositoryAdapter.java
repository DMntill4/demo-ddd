package com.backintro.infrastructure.chataisettings.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.mappers.ChatAiSettingsPersistenceMapper;

public class ChatAiSettingsRepositoryAdapter implements ChatAiSettingsRepository {
    private final ChatAiSettingsJpaRepository repository;
    private final ChatAiSettingsPersistenceMapper mapper;

    public ChatAiSettingsRepositoryAdapter(ChatAiSettingsJpaRepository repository, ChatAiSettingsPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiSettings save(ChatAiSettings aggregate) {
        ChatAiSettingsJpaEntity entityObj = mapper.toJpa(aggregate);
        ChatAiSettingsJpaEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiSettings> findById(ChatAiSettingsId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiSettings> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return repository.existsByCode(code);
    }

    @Override
    public void delete(ChatAiSettings aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
