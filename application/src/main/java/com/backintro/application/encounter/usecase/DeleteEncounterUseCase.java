package com.backintro.application.encounter.usecase;

import com.backintro.application.encounter.exception.EncounterNotFoundApplicationException;
import com.backintro.domain.encounter.model.aggregate.Encounter;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.domain.encounter.port.repository.EncounterRepository;

public class DeleteEncounterUseCase {
    private final EncounterRepository repository;

    public DeleteEncounterUseCase(EncounterRepository repository) {
        this.repository = repository;
    }

    public void execute(EncounterId id) {
        Encounter aggregate = repository.findById(id)
                .orElseThrow(() -> new EncounterNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
