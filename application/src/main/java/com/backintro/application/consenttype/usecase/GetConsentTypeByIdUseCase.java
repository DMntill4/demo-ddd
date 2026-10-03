package com.backintro.application.consenttype.usecase;

import com.backintro.application.consenttype.dto.ConsentTypeResponse;
import com.backintro.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class GetConsentTypeByIdUseCase {
    private final ConsentTypeRepository repository;

    public GetConsentTypeByIdUseCase(ConsentTypeRepository repository) {
        this.repository = repository;
    }

    public ConsentTypeResponse execute(ConsentTypeId id) {
        return repository.findById(id)
                .map(ConsentTypeResponse::fromDomain)
                .orElseThrow(() -> new ConsentTypeNotFoundApplicationException(id));
    }
}
