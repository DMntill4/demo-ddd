package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.command.RegisterProviderModelAiCommand;
import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class RegisterProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public RegisterProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(RegisterProviderModelAiCommand command) {
        if (repository.existsByCode(command.code())) {
            throw new IllegalArgumentException("ProviderModelAi code already exists: " + command.code());
        }
        ProviderModelAi aggregate = ProviderModelAi.register(command.name(), command.code());
        ProviderModelAi saved = repository.save(aggregate);
        return ProviderModelAiResponse.fromDomain(saved);
    }
}
