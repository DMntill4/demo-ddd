package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers;

import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricJpaEntity;

public class ChatAiRunMetricPersistenceMapper {
    public ChatAiRunMetricJpaEntity toJpa(ChatAiRunMetric aggregate) {
        if (aggregate == null) return null;
        return new ChatAiRunMetricJpaEntity(aggregate.id().value(), aggregate.aiRunId(), aggregate.promptTokens(), aggregate.completionTokens(), aggregate.totalTokens(), aggregate.cost(), aggregate.createdAt());
    }

    public ChatAiRunMetric toDomain(ChatAiRunMetricJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiRunMetric.restore(new ChatAiRunMetricId(entityObj.getId()), entityObj.getAiRunId(), entityObj.getPromptTokens(), entityObj.getCompletionTokens(), entityObj.getTotalTokens(), entityObj.getCost(), entityObj.getCreatedAt());
    }
}
