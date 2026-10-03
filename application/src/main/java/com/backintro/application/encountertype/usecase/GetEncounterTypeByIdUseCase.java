package com.backintro.application.encountertype.usecase;

import com.backintro.application.encountertype.dto.EncounterTypeResponse;
import com.backintro.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class GetEncounterTypeByIdUseCase {
    private final EncounterTypeRepository repository;

    public GetEncounterTypeByIdUseCase(EncounterTypeRepository repository) {
        this.repository = repository;
    }

    public EncounterTypeResponse execute(EncounterTypeId id) {
        return repository.findById(id)
                .map(EncounterTypeResponse::fromDomain)
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(id));
    }
}
