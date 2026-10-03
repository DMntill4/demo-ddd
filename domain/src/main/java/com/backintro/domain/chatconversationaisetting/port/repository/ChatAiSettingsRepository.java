package com.backintro.domain.chatconversationaisetting.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;

public interface ChatAiSettingsRepository {
    ChatAiSettings save(ChatAiSettings aggregate);
    Optional<ChatAiSettings> findById(ChatAiSettingsId id);
    List<ChatAiSettings> findAll();
    void delete(ChatAiSettings aggregate);
}
