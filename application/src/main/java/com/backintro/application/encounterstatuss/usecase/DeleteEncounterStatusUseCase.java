package com.backintro.application.encounterstatuss.usecase;

import com.backintro.application.encounterstatuss.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;

public class DeleteEncounterStatusUseCase {
    private final EncounterStatusRepository repository;

    public DeleteEncounterStatusUseCase(EncounterStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(EncounterStatusId id) {
        EncounterStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
