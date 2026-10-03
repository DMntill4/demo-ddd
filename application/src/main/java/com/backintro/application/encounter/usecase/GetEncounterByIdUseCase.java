package com.backintro.application.encounter.usecase;

import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.application.encounter.exception.EncounterNotFoundApplicationException;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.domain.encounter.port.repository.EncounterRepository;

public class GetEncounterByIdUseCase {
    private final EncounterRepository repository;

    public GetEncounterByIdUseCase(EncounterRepository repository) {
        this.repository = repository;
    }

    public EncounterResponse execute(EncounterId id) {
        return repository.findById(id)
                .map(EncounterResponse::fromDomain)
                .orElseThrow(() -> new EncounterNotFoundApplicationException(id));
    }
}
