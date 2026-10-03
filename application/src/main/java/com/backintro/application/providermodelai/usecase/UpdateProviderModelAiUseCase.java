package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.command.UpdateProviderModelAiCommand;
import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class UpdateProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public UpdateProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(UpdateProviderModelAiCommand command) {
        ProviderModelAi aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        ProviderModelAi saved = repository.save(aggregate);
        return ProviderModelAiResponse.fromDomain(saved);
    }
}
