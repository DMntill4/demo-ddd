package com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;

public class ChatAiSettingsPersistenceMapper {
    public ChatAiSettingsJpaEntity toJpa(ChatAiSettings aggregate) {
        if (aggregate == null) return null;
        return new ChatAiSettingsJpaEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.aiEnabled(), aggregate.defaultModelId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ChatAiSettings toDomain(ChatAiSettingsJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiSettings.restore(new ChatAiSettingsId(entityObj.getId()), entityObj.getConversationId(), entityObj.getAiEnabled(), entityObj.getDefaultModelId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
