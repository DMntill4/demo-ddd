package com.backintro.domain.chataisettings.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;

public interface ChatAiSettingsRepository {
    ChatAiSettings save(ChatAiSettings aggregate);
    Optional<ChatAiSettings> findById(ChatAiSettingsId id);
    List<ChatAiSettings> findAll();
    boolean existsByCode(String code);
    void delete(ChatAiSettings aggregate);
}
