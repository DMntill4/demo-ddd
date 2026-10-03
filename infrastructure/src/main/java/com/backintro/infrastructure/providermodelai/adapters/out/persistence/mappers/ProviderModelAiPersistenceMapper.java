package com.backintro.infrastructure.providermodelai.adapters.out.persistence.mappers;

import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;

public class ProviderModelAiPersistenceMapper {
    public ProviderModelAiJpaEntity toJpa(ProviderModelAi aggregate) {
        if (aggregate == null) return null;
        return new ProviderModelAiJpaEntity(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }

    public ProviderModelAi toDomain(ProviderModelAiJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ProviderModelAi.restore(
                new ProviderModelAiId(entityObj.getId()),
                entityObj.getName(),
                entityObj.getCode(),
                entityObj.isActive()
        );
    }
}
