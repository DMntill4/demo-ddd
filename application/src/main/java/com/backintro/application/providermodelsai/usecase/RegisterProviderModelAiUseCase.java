package com.backintro.application.providermodelsai.usecase;

import com.backintro.application.providermodelsai.command.RegisterProviderModelAiCommand;
import com.backintro.application.providermodelsai.dto.ProviderModelAiResponse;
import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;

public class RegisterProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public RegisterProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(RegisterProviderModelAiCommand command) {
        ProviderModelAi aggregate = ProviderModelAi.register(command.nameProviderAi(), command.razonSocial(), command.sitioWeb());
        ProviderModelAi saved = repository.save(aggregate);
        return ProviderModelAiResponse.fromDomain(saved);
    }
}
