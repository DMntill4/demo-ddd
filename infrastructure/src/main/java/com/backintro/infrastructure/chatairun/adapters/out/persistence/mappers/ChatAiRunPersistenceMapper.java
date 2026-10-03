package com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers;

import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunJpaEntity;

public class ChatAiRunPersistenceMapper {
    public ChatAiRunJpaEntity toJpa(ChatAiRun aggregate) {
        if (aggregate == null) return null;
        return new ChatAiRunJpaEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.messageId(), aggregate.modelId(), aggregate.aiRunStatusId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ChatAiRun toDomain(ChatAiRunJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiRun.restore(new ChatAiRunId(entityObj.getId()), entityObj.getConversationId(), entityObj.getMessageId(), entityObj.getModelId(), entityObj.getAiRunStatusId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
