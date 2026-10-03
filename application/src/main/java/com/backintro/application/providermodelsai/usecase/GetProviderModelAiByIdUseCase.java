package com.backintro.application.providermodelsai.usecase;

import com.backintro.application.providermodelsai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelsai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;

public class GetProviderModelAiByIdUseCase {
    private final ProviderModelAiRepository repository;

    public GetProviderModelAiByIdUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(ProviderModelAiId id) {
        return repository.findById(id)
                .map(ProviderModelAiResponse::fromDomain)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id));
    }
}
