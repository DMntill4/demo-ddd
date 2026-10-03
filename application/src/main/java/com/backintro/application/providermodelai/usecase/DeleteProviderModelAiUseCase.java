package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class DeleteProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public DeleteProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public void execute(ProviderModelAiId id) {
        ProviderModelAi aggregate = repository.findById(id)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
