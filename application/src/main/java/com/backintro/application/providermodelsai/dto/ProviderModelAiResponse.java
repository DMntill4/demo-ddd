package com.backintro.application.providermodelsai.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;

public record ProviderModelAiResponse(UUID id, String nameProviderAi, String razonSocial, String sitioWeb, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static ProviderModelAiResponse fromDomain(ProviderModelAi aggregate) {
        return new ProviderModelAiResponse(aggregate.id().value(), aggregate.nameProviderAi(), aggregate.razonSocial(), aggregate.sitioWeb(), aggregate.isActive(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
