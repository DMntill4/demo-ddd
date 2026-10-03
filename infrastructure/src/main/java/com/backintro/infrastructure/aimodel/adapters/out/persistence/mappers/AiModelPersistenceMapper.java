package com.backintro.infrastructure.aimodel.adapters.out.persistence.mappers;

import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;

public class AiModelPersistenceMapper {
    public AiModelJpaEntity toJpa(AiModel aggregate) {
        if (aggregate == null) return null;
        return new AiModelJpaEntity(aggregate.id().value(), aggregate.providerModelId(), aggregate.nameModel(), aggregate.modelKey(), aggregate.inputTokenPrice(), aggregate.outputTokenPrice(), aggregate.maxTokens(), aggregate.contextWindow(), aggregate.isActive(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public AiModel toDomain(AiModelJpaEntity entityObj) {
        if (entityObj == null) return null;
        return AiModel.restore(new AiModelId(entityObj.getId()), entityObj.getProviderModelId(), entityObj.getNameModel(), entityObj.getModelKey(), entityObj.getInputTokenPrice(), entityObj.getOutputTokenPrice(), entityObj.getMaxTokens(), entityObj.getContextWindow(), entityObj.getIsActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
