package com.backintro.application.providermodelsai.usecase;

import com.backintro.application.providermodelsai.command.UpdateProviderModelAiCommand;
import com.backintro.application.providermodelsai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelsai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;

public class UpdateProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public UpdateProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(UpdateProviderModelAiCommand command) {
        ProviderModelAi aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(command.id()));
        aggregate.update(command.nameProviderAi(), command.razonSocial(), command.sitioWeb());
        ProviderModelAi saved = repository.save(aggregate);
        return ProviderModelAiResponse.fromDomain(saved);
    }
}
