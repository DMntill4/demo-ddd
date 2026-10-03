package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class DeleteEncounterModalityUseCase {
    private final EncounterModalityRepository repository;

    public DeleteEncounterModalityUseCase(EncounterModalityRepository repository) {
        this.repository = repository;
    }

    public void execute(EncounterModalityId id) {
        EncounterModality aggregate = repository.findById(id)
                .orElseThrow(() -> new EncounterModalityNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
