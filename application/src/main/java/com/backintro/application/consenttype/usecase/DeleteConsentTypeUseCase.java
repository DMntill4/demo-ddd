package com.backintro.application.consenttype.usecase;

import com.backintro.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class DeleteConsentTypeUseCase {
    private final ConsentTypeRepository repository;

    public DeleteConsentTypeUseCase(ConsentTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(ConsentTypeId id) {
        ConsentType aggregate = repository.findById(id)
                .orElseThrow(() -> new ConsentTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
