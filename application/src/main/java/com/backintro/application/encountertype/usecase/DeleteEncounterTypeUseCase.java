package com.backintro.application.encountertype.usecase;

import com.backintro.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class DeleteEncounterTypeUseCase {
    private final EncounterTypeRepository repository;

    public DeleteEncounterTypeUseCase(EncounterTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(EncounterTypeId id) {
        EncounterType aggregate = repository.findById(id)
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
