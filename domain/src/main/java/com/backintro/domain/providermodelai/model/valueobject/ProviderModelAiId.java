package com.backintro.domain.providermodelai.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ProviderModelAiId(UUID value) {
    public ProviderModelAiId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static ProviderModelAiId generate() {
        return new ProviderModelAiId(UUID.randomUUID());
    }
}
