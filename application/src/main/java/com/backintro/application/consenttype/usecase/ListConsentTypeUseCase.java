package com.backintro.application.consenttype.usecase;

import java.util.List;
import com.backintro.application.consenttype.dto.ConsentTypeResponse;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class ListConsentTypeUseCase {
    private final ConsentTypeRepository repository;

    public ListConsentTypeUseCase(ConsentTypeRepository repository) {
        this.repository = repository;
    }

    public List<ConsentTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ConsentTypeResponse::fromDomain)
                .toList();
    }
}
