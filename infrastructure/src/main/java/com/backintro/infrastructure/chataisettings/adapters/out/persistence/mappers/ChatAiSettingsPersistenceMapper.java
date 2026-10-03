package com.backintro.infrastructure.chataisettings.adapters.out.persistence.mappers;

import com.backintro.domain.chataisettings.model.aggregate.ChatAiSettings;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;

public class ChatAiSettingsPersistenceMapper {
    public ChatAiSettingsJpaEntity toJpa(ChatAiSettings aggregate) {
        if (aggregate == null) return null;
        return new ChatAiSettingsJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public ChatAiSettings toDomain(ChatAiSettingsJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiSettings.restore(
                new ChatAiSettingsId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
