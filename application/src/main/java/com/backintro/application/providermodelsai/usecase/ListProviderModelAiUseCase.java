package com.backintro.application.providermodelsai.usecase;

import java.util.List;
import com.backintro.application.providermodelsai.dto.ProviderModelAiResponse;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;

public class ListProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public ListProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public List<ProviderModelAiResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ProviderModelAiResponse::fromDomain)
                .toList();
    }
}
