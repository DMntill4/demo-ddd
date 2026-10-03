package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

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
