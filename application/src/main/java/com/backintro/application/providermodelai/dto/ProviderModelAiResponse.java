package com.backintro.application.providermodelai.dto;

import java.util.UUID;
import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;

public record ProviderModelAiResponse(UUID id, String name, String code, boolean active) {
    public static ProviderModelAiResponse fromDomain(ProviderModelAi aggregate) {
        return new ProviderModelAiResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
